package com.hanxiaocu.sample;

import com.hanxiaocu.sample.config.ConfigBean;
import com.hanxiaocu.sample.config.CustomBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/22
 */


@ImportResource(locations = {"classpath:applicationContext.xml"})
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, CustomBean.class})
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        logger.info("---------App Begin-------");
        SpringApplication app = new SpringApplication(Application.class);
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}
