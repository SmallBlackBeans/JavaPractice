package com.hanxiaocu.springbootlimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringbootLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLimiterApplication.class, args);
	}
}
