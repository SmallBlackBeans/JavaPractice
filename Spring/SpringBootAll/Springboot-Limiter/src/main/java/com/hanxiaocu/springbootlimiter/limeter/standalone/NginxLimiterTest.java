package com.hanxiaocu.springbootlimiter.limeter.standalone;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/21 2:30 PM
 */
public class NginxLimiterTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ScheduledExecutorService service = new ScheduledThreadPoolExecutor(5,new BasicThreadFactory.Builder().daemon(true).namingPattern("pool-thread-%d").build());
		for (int i = 0; i < 6; i++) {
			CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
				final ResponseEntity<String> entity = new RestTemplate().getForEntity("http://192.168.0.133:70/index", String.class);
				return entity.getBody();
			}, service).thenAccept(System.out::println);
		}
		service.shutdown();
	}
}
