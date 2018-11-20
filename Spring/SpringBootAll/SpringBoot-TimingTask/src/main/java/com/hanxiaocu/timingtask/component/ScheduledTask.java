package com.hanxiaocu.timingtask.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 3:38 PM
 */
@Component
@Slf4j
public class ScheduledTask {

	/**
	 * 自动扫描 启动时间 之后5秒执行一次
	 */
	//加入自定义线程池，来实现不同任务使用不同的线程进行任务执行
	@Async("scheduledPoolTaskExecutor")
	@Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void getCurrentDate() {
		log.info("Scheduled定时任务执行：" + new Date());
	}



	@Async
	@Scheduled(cron = "0/5 * * * * * *")
	public void scheduled() throws InterruptedException {
		Thread.sleep(3000);
		log.info("每5秒执行一次");
	}
}
