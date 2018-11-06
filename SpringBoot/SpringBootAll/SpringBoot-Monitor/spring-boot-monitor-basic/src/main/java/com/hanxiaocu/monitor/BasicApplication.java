package com.hanxiaocu.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 * Date: 2018/10/30 1:12 PM
 * @author hanchenghai
 */
@SpringBootApplication
public class BasicApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BasicApplication.class);
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}
