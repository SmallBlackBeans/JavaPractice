package com.hanxiaocu.springbootlimiter.limeter.standalone;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @desc: 计数器限流
 * @author: hanchenghai
 * @date: 2018/11/21 11:43 AM
 */
public class AtomicLimiterTest {

	/**
	 * 计数器限流算法（比较暴力/超出直接拒绝）
	 * Atomic，限制总数
	 */
	private static final AtomicInteger atomic = new AtomicInteger(0);

	private void atomicLimiter() {
		// 最大支持 3 個
		if (atomic.get() >= 3) {
			System.out.println(atomic.get());
			System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getName() + " - " + "拒絕...");
		} else {
			try {
				atomic.incrementAndGet();
				//处理核心逻辑
				System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getName() + " - " + "通过...");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				atomic.decrementAndGet();
			}
		}

	}

	@Test
	public void testAtomic() throws InterruptedException {
		ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(5, new BasicThreadFactory.Builder().namingPattern("pool-thread-%d").daemon(true).build());
		for (int i = 0; i < 5; i++) {
			service.execute(this::atomicLimiter);
		}
		TimeUnit.SECONDS.sleep(5);
	}
}
