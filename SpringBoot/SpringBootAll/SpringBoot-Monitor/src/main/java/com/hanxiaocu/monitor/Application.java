package com.hanxiaocu.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 1:12 PM
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}
