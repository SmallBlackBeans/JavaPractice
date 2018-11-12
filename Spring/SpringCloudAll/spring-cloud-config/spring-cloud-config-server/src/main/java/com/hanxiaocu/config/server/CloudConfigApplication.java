package com.hanxiaocu.config.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @desc: 配置中心 server
 * @author: hanchenghai
 * @date: 2018/11/12 9:34 AM
 */
@SpringBootApplication
@EnableConfigServer
@Slf4j
public class CloudConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudConfigApplication.class,args);
		log.info("spring-cloud-config-server启动... ");
	}
}
