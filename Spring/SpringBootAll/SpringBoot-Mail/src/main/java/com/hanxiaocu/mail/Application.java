package com.hanxiaocu.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 3:16 PM
 */
@SpringBootApplication
@Slf4j
public class Application {
	public static void main(String[] args) {
		log.info("启动了...");
		new SpringApplication(Application.class).run(args);
	}
}
