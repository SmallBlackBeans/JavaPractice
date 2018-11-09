package com.hanxiaocu.hystrix.dashboard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @desc: 熔断监控面板
 * @author: hanchenghai
 * @date: 2018/11/09 5:05 PM
 */
@SpringBootApplication
@EnableHystrixDashboard
@Slf4j
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
		log.info("spring-cloud-hystrix-dashboard启动!");
	}
}