package com.hanxiaocu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/07 6:02 PM
 */
@SpringBootApplication
//公共字段自动填充功能
@EnableJpaAuditing

@EnableJpaRepositories(basePackages = "com.hanxiaocu.repositories.jpa")
@EnableMongoRepositories(basePackages = "com.hanxiaocu.repositories.mongo")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
