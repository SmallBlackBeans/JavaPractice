package com.hanxiaocu.async.controller;

import com.hanxiaocu.async.component.SyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 2:52 PM
 */
@RestController
@Slf4j
public class AsyncController {


	@Autowired
	SyncService syncService;


	@GetMapping("/async")
	public String doAsync() throws InterruptedException, TimeoutException, ExecutionException {
		long start = System.currentTimeMillis();
		log.info("方法执行开始：{}", start);
		//调用同步方法
		syncService.syncEvent();
		long syncTime = System.currentTimeMillis();
		log.info("同步方法用时：{}", syncTime - start);
		//调用异步方法
		Future<String> doFuture = syncService.asyncEvent();
		//get方法会一直堵塞，直到等待执行完成才返回
		//get(long timeout, TimeUnit unit) 在设置时间类未返回结果，会直接排除异常TimeoutException，messages为null
		String result = doFuture.get(60, TimeUnit.SECONDS);//60s
		while (true) {
			//判断异步任务是否完成
			if (doFuture.isDone()){
				long asyncTime = System.currentTimeMillis();
				log.info("异步方法用时：{}", asyncTime - syncTime);
				break;
			}
			Thread.sleep(100);
		}
		log.info("当前方法执行完成：{}!",System.currentTimeMillis());
		return "async!!!";
	}

}
