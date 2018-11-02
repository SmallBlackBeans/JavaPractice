package com.hanxiaocu.webapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.LoggingSystem;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 2:08 PM
 */
@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
		log.info("启动了，鸡不鸡动");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("启动前先执行一些东西....");
	}
}
