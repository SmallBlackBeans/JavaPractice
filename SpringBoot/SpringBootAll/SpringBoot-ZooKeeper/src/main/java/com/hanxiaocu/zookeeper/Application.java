package com.hanxiaocu.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 11:22 AM
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        //禁用解析命令行参数
        application.setAddCommandLineProperties(false);
        application.run(args);
    }
}
