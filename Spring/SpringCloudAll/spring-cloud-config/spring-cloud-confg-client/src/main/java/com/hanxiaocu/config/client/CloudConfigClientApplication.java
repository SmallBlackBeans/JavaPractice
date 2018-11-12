package com.hanxiaocu.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 10:44 AM
 */
@SpringBootApplication
@Slf4j
public class CloudConfigClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class,args);
		log.info("spring-cloud-config-client 启动...");
	}
}
