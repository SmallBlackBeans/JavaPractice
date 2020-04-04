package com.hanxiaocu.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc: cxf 服务发布示例
 * @author: hanchenghai
 * @date: 2018/11/13 2:13 PM
 */
@SpringBootApplication
@Slf4j
public class CxfServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CxfServiceApplication.class, args);
		log.info("spirng-boot-cxf-service 启动...");
	}
}
