package com.hanxiaocu.sample.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 4:33 PM
 */
@Configuration
public class FilterConf {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(customFilter());
        registration.addUrlPatterns("/*");
        //支持设置注册顺序
        registration.setOrder(10);
        return registration;
    }

    @Bean
    public Filter customFilter() {
        return new CustomFilter();
    }
}
