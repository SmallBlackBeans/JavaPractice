package com.hanxiaocu.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/07 4:56 PM
 */
@SpringBootApplication
@Slf4j
public class ProviderApplication {
	public static void main(String[] args) {
		//只是单纯的提供一个服务，不需要web环境
		// new SpringApplicationBuilder(ProviderApplication.class).web(WebApplicationType.NONE).run(args);
		SpringApplication.run(ProviderApplication.class,args);
		log.info("spring-boot-dubbo-provider 启动...");
	}
}
