package com.hanxiaocu.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/07 6:02 PM
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//公共字段自动填充功能
@EnableJpaAuditing
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
