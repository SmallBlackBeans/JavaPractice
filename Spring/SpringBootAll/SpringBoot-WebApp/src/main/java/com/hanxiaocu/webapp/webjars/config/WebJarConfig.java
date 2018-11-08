package com.hanxiaocu.webapp.webjars.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 3:54 PM
 */
@Configuration
public class WebJarConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/static/**")
		// 		.addResourceLocations("classpath:/static");
		//配置映射关系
		//即：/webjars/** 映射到 classpath:/META-INF/resources/webjars/
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/")
				//新增 resourceChain 配置即开启缓存配置。
				//不知道为何不加这个配置 设置了 webjars-locator 未生效
				.resourceChain(true);//生产时建议开启缓存（只是缓存了资源路径而不是资源内容）,开发是可以设置为false
	}
}
