package com.hanxiaocu.springbootlimiter.limeter.standalone;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @desc: 信号量实现漏桶算法
 * @author: hanchenghai
 * @date: 2018/11/21 11:33 AM
 */
public class SemaphoreLimiterTest {

	/**
	 * 计数器限流算法（允许将任务放入到缓冲队列）
	 * 信号量，用来达到削峰的目的 初始3个占位可以获取
	 */
	private final static Semaphore semaphore = new Semaphore(3);


	private void semaphoreLimiter() {
		// 队列中允许存活的任务个数不能超过 5 个
		if (semaphore.getQueueLength() > 5) {
			System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getName() + " - 拒絕...");
		} else {
			try {
				//添加消费任务
				semaphore.acquire();
				System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getName() + " - 通过...");
				//处理核心逻辑 延迟这个任务的时长，让桶中任务数量超过5个
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}
	}

	@Test
	public void testSemaphore() throws InterruptedException {
		ScheduledExecutorService service = new ScheduledThreadPoolExecutor(10,
				new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build());
		for (int i = 0; i < 10; i++) {
			service.execute(this::semaphoreLimiter);
		}
		TimeUnit.SECONDS.sleep(5);
	}

}
