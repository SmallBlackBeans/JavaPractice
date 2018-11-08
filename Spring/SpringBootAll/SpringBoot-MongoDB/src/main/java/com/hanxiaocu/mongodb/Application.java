package com.hanxiaocu.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */
@SpringBootApplication
@EnableMongoAuditing
//默认扫描启动类所在包下的路径
// @EnableMongoRepositories(basePackages = )
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}
