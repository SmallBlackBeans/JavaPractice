package com.hanxiaocu.sample.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 4:42 PM
 */
@Configuration
public class WebMvcConf implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器，拦截规则
        //顺序添加
        registry.addInterceptor(handlerInterceptor());
    }

    @Bean
    public static HandlerInterceptor handlerInterceptor() {
        return new CustomHandlerInterceptor();
    }
}
