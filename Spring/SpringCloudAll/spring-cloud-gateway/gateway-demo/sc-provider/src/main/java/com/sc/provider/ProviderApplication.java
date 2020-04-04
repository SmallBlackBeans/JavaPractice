package com.sc.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/18 1:59 PM
 */
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class ProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class,args);
		log.info("eureka provider 启动...");
	}
}
