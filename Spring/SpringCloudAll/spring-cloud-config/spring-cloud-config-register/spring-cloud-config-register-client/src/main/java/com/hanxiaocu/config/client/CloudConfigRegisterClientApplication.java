package com.hanxiaocu.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @desc: 服务化 访问 配置中心
 * @author: hanchenghai
 * @date: 2018/11/12 11:32 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class CloudConfigRegisterClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudConfigRegisterClientApplication.class,args);
		log.info("spring-cloud-config-register-client 启动...");
	}
}
