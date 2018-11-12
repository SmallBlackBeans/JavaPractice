package com.hanxiaocu.zuul.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @desc: 接口服务器 one   http://127.0.0.1:7089/swagger-ui.html
 * @author: hanchenghai
 * @date: 2018/11/12 3:43 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ServiceOneApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class,args);
		log.info("spring-cloud-zuul-service-one 启动了...");
	}
}
