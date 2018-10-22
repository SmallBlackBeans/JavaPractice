package com.hanxiaocu.sample.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description: 自定义配置文件
 * User: hanchenghai
 * Date: 2018/10/22
 */
@Configuration
@ConfigurationProperties(prefix="custom")
@PropertySource("classpath:custom.properties")
@Component
public class CustomBean {
    private String name;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
