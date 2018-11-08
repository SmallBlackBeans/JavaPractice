package com.hanxiaocu.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 11:51 AM
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		new SpringApplication(Application.class).run(args);
	}
}
