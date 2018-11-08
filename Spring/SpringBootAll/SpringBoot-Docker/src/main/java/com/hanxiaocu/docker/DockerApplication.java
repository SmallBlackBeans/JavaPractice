package com.hanxiaocu.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 10:05 AM
 */

@SpringBootApplication
public class DockerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DockerApplication.class);
		app.run(args);
	}
}
