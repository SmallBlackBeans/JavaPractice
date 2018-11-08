package com.hanxiaocu.eureka.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @desc: 提供服务的服务端
 * @author: hanchenghai
 * @date: 2018/11/08 4:30 PM
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class,args);
		log.info("spring-cloud-eureka-service 2号中心 启动！");
	}
}
