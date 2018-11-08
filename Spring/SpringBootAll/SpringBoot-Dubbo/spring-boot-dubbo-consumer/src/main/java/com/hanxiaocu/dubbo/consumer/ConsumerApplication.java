package com.hanxiaocu.dubbo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/07 5:39 PM
 */
@Slf4j
@SpringBootApplication
public class ConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class,args);
		log.info("spring-boot-dubbo-consumer 启动了...");
	}
}
