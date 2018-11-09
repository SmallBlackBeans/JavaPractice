package com.hanxiaocu.eureka.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/09 2:13 PM
 */
@SpringBootApplication
@EnableFeignClients //开启feign支持
@Slf4j
public class EurekaConsumerFeignApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaConsumerFeignApplication.class, args);
		log.info("spring-cloud-eureka-consumer-feign 启动...");
	}
}
