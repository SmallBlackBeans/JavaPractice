package com.hanxiaocu.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 2:13 PM
 */

@SpringBootApplication
@EnableAsync
@Slf4j
public class Application {

	public static void main(String[] args) {
		log.info("启动了...");
		new SpringApplication(Application.class).run(args);
	}
}
