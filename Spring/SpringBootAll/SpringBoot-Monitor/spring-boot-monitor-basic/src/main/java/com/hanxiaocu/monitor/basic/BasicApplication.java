package com.hanxiaocu.monitor.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/07 10:56 AM
 */
@SpringBootApplication
public class BasicApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BasicApplication.class);
		app.run(args);
	}
}
