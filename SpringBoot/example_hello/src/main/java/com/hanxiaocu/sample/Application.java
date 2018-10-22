package com.hanxiaocu.sample;

import com.hanxiaocu.sample.beans.ConfigBean;
import com.hanxiaocu.sample.beans.CustomBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/22
 */
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class,CustomBean.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}
