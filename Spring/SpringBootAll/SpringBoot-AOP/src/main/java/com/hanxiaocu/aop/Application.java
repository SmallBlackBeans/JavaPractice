package com.hanxiaocu.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 5:39 PM
 */
@SpringBootApplication
//开启aop注解
@EnableAspectJAutoProxy
@Slf4j
public class Application {
	public static void main(String[] args) {
		log.info("呜呜呜呜，开车了...");
		new SpringApplication(Application.class).run(args);
	}
}
