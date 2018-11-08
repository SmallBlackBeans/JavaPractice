package com.hanxiaocu.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/22
 */
@Component
public class AppProperties {
    @Value("${hanxiaocu.name}")
    private String name;
    @Value("${hanxiaocu.title}")
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
