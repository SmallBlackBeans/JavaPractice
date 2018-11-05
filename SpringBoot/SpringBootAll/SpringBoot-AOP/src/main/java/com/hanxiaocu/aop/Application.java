package com.hanxiaocu.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 5:39 PM
 */
@SpringBootApplication
//开启注解
@EnableAspectJAutoProxy
public class Application {
	public static void main(String[] args) {
		new SpringApplication(Application.class).run(args);
	}
}
