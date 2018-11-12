package com.hanxiaocu.zuul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 1:54 PM
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@Slf4j
public class SpringCloudZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApplication.class,args);
		log.info("spring-cloud-zuul 启动...");
	}
}
