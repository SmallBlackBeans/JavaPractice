package com.hanxiaocu.async.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc: Spring方式实现异步请求
 * @author: hanchenghai
 * @date: 2018/11/05 2:16 PM
 */
@Slf4j
@RestController
public class SpringController {


	//方式一：Callable 包裹
	@RequestMapping("/callable")
	public Callable<String> callable() {
		log.info("外部线程：" + Thread.currentThread().getName());
		return new Callable<String>() {
			@Override
			public String call() throws Exception {
				log.info("内部线程：" + Thread.currentThread().getName());
				return "callable!";
			}
		};
	}

	/**
	 *
	 * 利用DeferredResult可实现一些长连接的功能
	 * 可以在另一个线程里面进行业务处理及返回，即可在两个完全不相干的线程间的通信
	 * @return
	 */
	@RequestMapping("/deferredresult")
	public DeferredResult<String> deferredResult(){
		log.info("外部线程：" + Thread.currentThread().getName());
		//设置超时时间
		DeferredResult<String> result = new DeferredResult<String>(60*1000L);
		//处理超时事件 采用委托机制
		result.onTimeout(new Runnable() {

			@Override
			public void run() {
				log.error("DeferredResult超时");
				result.setResult("超时了!");
			}
		});
		result.onCompletion(new Runnable() {

			@Override
			public void run() {
				//完成后
				log.info("调用完成");
			}
		});
		FIXED_THREAD_POOL.execute(new Runnable() {

			@Override
			public void run() {
				//处理业务逻辑
				log.info("内部线程：" + Thread.currentThread().getName());
				//返回结果
				result.setResult("DeferredResult!!");
			}
		});
		return result;
	}

	/**
	 * 线程池
	 */
	public static ExecutorService FIXED_THREAD_POOL = Executors.newFixedThreadPool(30);


	//WebAsyncTask是直接返回了
	@RequestMapping("/webAsyncTask")
	public WebAsyncTask<String> webAsyncTask() {
		log.info("外部线程：" + Thread.currentThread().getName());
		WebAsyncTask<String> result = new WebAsyncTask<String>(60*1000L, new Callable<String>() {

			@Override
			public String call() throws Exception {
				log.info("内部线程：" + Thread.currentThread().getName());
				return "WebAsyncTask!!!";
			}
		});
		result.onTimeout(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "WebAsyncTask超时!!!";
			}
		});
		result.onCompletion(new Runnable() {

			@Override
			public void run() {
				//超时后 也会执行此方法
				log.info("WebAsyncTask执行结束");
			}
		});
		return result;
	}

}
