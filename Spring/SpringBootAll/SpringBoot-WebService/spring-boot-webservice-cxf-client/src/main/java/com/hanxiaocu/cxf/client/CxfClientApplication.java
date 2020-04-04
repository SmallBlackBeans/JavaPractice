package com.hanxiaocu.cxf.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/13 2:53 PM
 */
@SpringBootApplication
@Slf4j
public class CxfClientApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CxfClientApplication.class, args);
		log.info("spring-boot-cxf-client-chapter34启动!");
	}
}
