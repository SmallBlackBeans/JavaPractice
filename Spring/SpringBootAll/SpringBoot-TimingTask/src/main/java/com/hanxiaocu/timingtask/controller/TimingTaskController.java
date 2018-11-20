package com.hanxiaocu.timingtask.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 3:20 PM
 */
@RestController
@Slf4j
public class TimingTaskController {

	@GetMapping("/timer")
	public String doTimer() {
		@SuppressWarnings("all")
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				log.info("Timer 定时任务启动: " + new Date());
			}
		}, 1000, 1000);//延迟1秒，每秒执行一次
		return "timer";
	}

	@GetMapping("/executor")
	public String ScheduledExecutorService() {
		// ScheduledExecutorService service = new ScheduledThreadPoolExecutor(10);
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		service.scheduleAtFixedRate(() -> log.info("ScheduledExecutorService 定时任务执行：" + new Date()), 1, 1, TimeUnit.SECONDS);
		log.info("ScheduledExecutorService 定时任务启动：" + new Date());
		return "ScheduledExecutorService";
	}

	@Autowired
	TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		//默认1
		taskScheduler.setPoolSize(10);
		return taskScheduler;
	}

	;

	//动态触发，添加定时任务
	@GetMapping("/poolTask")
	public String threadPoolTaskScheduler() {
		taskScheduler().schedule(() -> log.info("ThreadPoolTaskScheduler定时任务：" + new Date()), new CronTrigger("0/3 * * * * ?"));//每三秒执行一次

		return "ThreadPoolTaskScheduler!";
	}

}
