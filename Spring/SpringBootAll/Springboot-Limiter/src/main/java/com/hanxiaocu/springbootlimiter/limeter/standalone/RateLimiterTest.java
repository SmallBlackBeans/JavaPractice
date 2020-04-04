package com.hanxiaocu.springbootlimiter.limeter.standalone;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @desc: Google Guava 中使用的令牌桶算法
 * @author: hanchenghai
 * @date: 2018/11/21 9:56 AM
 */
public class RateLimiterTest {

	/**
	 * 令牌桶算法
	 * 每秒生成 2 个令牌
	 * 每500ms 生成一个
	 */
	private static final RateLimiter limeter = RateLimiter.create(2);

	private void rateLimter() {
		//acquire 每秒取1个令牌
		//当桶中有足够的令牌时，则直接返回0，否则阻塞，直到有可用的令牌数才返回，返回的值为阻塞的时间。
		final double acquire = limeter.acquire(1);
		System.out.println("当前时间 - " + LocalDateTime.now() + " - " + Thread.currentThread().getName() + " - 阻塞时间：" + acquire + " 通过... ");
	}


	@Test
	public void testDemo() throws InterruptedException {
		ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5,
				new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build());

		for (int i = 0; i < 5; i++) {
			executorService.execute(this::rateLimter);
		}
		TimeUnit.SECONDS.sleep(5);

	}
}
