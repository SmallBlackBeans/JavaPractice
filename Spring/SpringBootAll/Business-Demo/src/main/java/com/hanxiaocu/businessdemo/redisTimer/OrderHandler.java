package com.hanxiaocu.businessdemo.redisTimer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/22 9:50 AM
 * 时间格式化 https://blog.battcn.com/2018/10/01/springboot/v2-localdatetime/
 */

/**
 * 问题描述：
 * 让您做一个电商平台，您如何设置一个在买家下订单后的”第60秒“发短信通知卖家发货，
 * 您需要考虑的是 像淘宝一样的大并发量的订单。
 */
@Component
public class OrderHandler {

	private final RedisTemplate<String, Object> redisTemplate;

	@Autowired
	public OrderHandler(@Qualifier(value = "orderRedisTemplate") RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	// @Resource(name = "orderRedisTemplate")
	// private RedisTemplate<String,Object> redisTemplate;

	private Jedis jedis = new Jedis("127.0.0.1", 6379);

	private AtomicLong currentOrderId = new AtomicLong(0L);
	private SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final String KEY = "okders";

	@Scheduled(cron = "0/1 * * * * *")
	public void initData() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 60);//取当前下单事件后60s
		Map<String, Double> scores = new HashMap<>();
		//一天500W 订单，一天8小时，平均每秒170单
		for (int i = 0; i < 170; i++) {
			currentOrderId.getAndIncrement();//生成订单
			//任务的执行时间戳作为score
			scores.put(currentOrderId.toString(), (double) removeMillis(calendar));
			jedis.zadd(KEY, scores);
			System.out.println("[当前订单Id] - " + currentOrderId);
		}
	}

	@Scheduled(cron = "0/1 * * * * *")
	//每秒根据当前时间取一次数据，这一秒的数据就是60s 前添加进来的，现在到了触发的时间了
	public void consumer() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		long score = removeMillis(calendar);
		Set<String> orders = jedis.zrangeByScore(KEY, 0, score);
		if (orders.isEmpty() || orders.size() == 0){
			System.out.println("当前没有订单需要处理...");
		}

		for (String order : orders) {
			System.out.println("[处理订单] " + order);
			Long result = jedis.zrem(KEY, order);
			System.out.println("[处理完毕] " + order + "[处理结果] " + (result == 1) );
		}
	}

	private long removeMillis(Calendar calendar) throws ParseException {
		String date = sdFormatter.format(calendar.getTime());
		Date nowTime = sdFormatter.parse(date);
		System.out.println("[当前时间] - " + nowTime + "---毫秒数" + nowTime.getTime());
		return nowTime.getTime();
	}

}
