package com.hanxiaocu.sample.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description: 在属性非常多的情况下，也可以定义一个和配置文件对应的Bean
 * User: hanchenghai
 * Date: 2018/10/22
 */
@Configuration
@ConfigurationProperties(prefix="hanxiaocu")//通用前缀加属性名和配置文件的属性名一一对应。
@Component
public class ConfigBean {
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