package com.hanxiaocu.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 5:13 PM
 */
@SpringBootApplication
@EnableAdminServer
@Slf4j
public class AdminServerApplication {
	public static void main(String[] args) {
		log.info("AdminServer启动...");
		new SpringApplication(AdminServerApplication.class).run(args);
	}
}
