package com.hanxiaocu.eureka;

// import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
// import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @desc: Eureka 服务器
 * @author: hanchenghai
 * @date: 2018/11/12 3:38 PM
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaRegisterCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaRegisterCenterApplication.class, args);
		log.info("单机版 注册中心 启动了...");
	}
}
