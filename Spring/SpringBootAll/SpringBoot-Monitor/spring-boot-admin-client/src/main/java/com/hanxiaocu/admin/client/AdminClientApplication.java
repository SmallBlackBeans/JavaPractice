package com.hanxiaocu.admin.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 5:34 PM
 */
@SpringBootApplication
@Slf4j
public class AdminClientApplication {
	public static void main(String[] args) {
		log.info("AdminClient启动...");
		new SpringApplication(AdminClientApplication.class).run(args);
	}
}
