package com.hanxiaocu.eureka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/09 1:19 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class EurekaConsumerRibbonApplicaiton {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerRibbonApplicaiton.class,args);
		log.info("spring-cloud-eureka-consumer-ribbon 启动...");
	}

	//添加 @LoadBalanced 使其具备了使用LoadBalancerClient 进行负载均衡的能力
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return  new RestTemplate();
	}
}
