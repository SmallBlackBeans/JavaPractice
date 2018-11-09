package com.hanxiaocu.hystrix.turbine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @desc: 聚合数据 监控
 * @author: hanchenghai
 * @date: 2018/11/09 5:35 PM
 */
@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
@Slf4j
public class HystrixTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineApplication.class, args);
		log.info("spring-cloud-hystrix-turbine启动!");
	}
}
