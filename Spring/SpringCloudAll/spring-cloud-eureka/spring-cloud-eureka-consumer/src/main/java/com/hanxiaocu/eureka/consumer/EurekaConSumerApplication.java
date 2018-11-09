package com.hanxiaocu.eureka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @desc: 服务消费者
 * @author: hanchenghai
 * @date: 2018/11/09 9:55 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class EurekaConSumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaConSumerApplication.class, args);
		log.info("spring-cloud-eureka-consumer 启动");
	}

	//加入负载均衡能力
	//同时可根据applicationName 来访问服务
	//如http://EUREKA-CLIENT/add
	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
