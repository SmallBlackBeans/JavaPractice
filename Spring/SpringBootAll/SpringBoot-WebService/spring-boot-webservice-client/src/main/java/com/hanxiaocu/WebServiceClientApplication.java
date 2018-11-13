package com.hanxiaocu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/13 1:50 PM
 */
@SpringBootApplication
@Slf4j
public class WebServiceClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebServiceClientApplication.class, args);
		log.info("spring-boot-webservice-client 启动...");
	}

}
