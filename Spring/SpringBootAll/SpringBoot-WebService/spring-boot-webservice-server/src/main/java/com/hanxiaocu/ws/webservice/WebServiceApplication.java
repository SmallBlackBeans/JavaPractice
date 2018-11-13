package com.hanxiaocu.ws.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/13 11:58 AM
 */
@SpringBootApplication
@Slf4j
public class WebServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class,args);
		log.info("spring-boot-webservice-server 启动...");
	}
}
