package com.hanxiaocu.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/07 5:39 PM
 */
@Slf4j
@EnableDubboConfig
@SpringBootApplication
public class ConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class,args);
		log.info("spring-boot-dubbo-consumer 启动了...");
	}
}
