package com.hanxiaocu.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 2:18 PM
 */

/**
 * 系统使用的是默认的SimpleAsyncTaskExecutor进行线程创建
 * 这个是每次调用都创建一个线程，并不会有重用机制
 * 所以一般我们都需要自定义线程池
 */
@Configuration
public class CustomAsyncPool implements WebMvcConfigurer {

	/**
	 * 配置线程池
	 *
	 * @return
	 */
	@Bean(name = "asyncPoolTaskExecutor")
	//这个名称就可以在注解@Async中使用了
	public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		//线程池维护线程的最少数量
		taskExecutor.setCorePoolSize(20);
		// 线程池维护线程的最大数量,
		taskExecutor.setMaxPoolSize(200);
		//缓存队列
		taskExecutor.setQueueCapacity(25);
		taskExecutor.setKeepAliveSeconds(200);
		taskExecutor.setThreadNamePrefix("callable-");
		//线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

		//表明等待所有线程执行完，默认为false。
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		//等待的时间，因为不能无限的等待下去
		taskExecutor.setAwaitTerminationSeconds(60);

		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		//处理超时
		configurer.setDefaultTimeout(60 * 1000);
		configurer.registerCallableInterceptors(timeoutInterceptor());
		configurer.setTaskExecutor(getAsyncThreadPoolTaskExecutor());
	}

	@Bean
	public TimeoutCallableProcessor timeoutInterceptor() {
		return new TimeoutCallableProcessor();
	}
}
