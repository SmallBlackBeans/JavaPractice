package com.hanxiaocu.async.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 2:50 PM
 */
@Component
@Slf4j
public class SyncService {

	/**
	 * Future 需要异步回调的时候
	 * @return
	 * @throws InterruptedException
	 */
	@Async("asyncPoolTaskExecutor")
	public Future<String> asyncEvent() throws InterruptedException {
		Thread.sleep(1000);
		log.info("异步方法内部线程名称：{}!", Thread.currentThread().getName());
		return new AsyncResult<>("异步方法回调返回值");
	}

	public void syncEvent() throws InterruptedException {
		Thread.sleep(1000);
		//log.info("同步方法输出：{}!", System.currentTimeMillis());
	}
}
