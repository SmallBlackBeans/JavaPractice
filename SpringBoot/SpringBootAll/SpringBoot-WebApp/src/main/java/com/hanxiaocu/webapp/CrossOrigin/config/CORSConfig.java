package com.hanxiaocu.webapp.CrossOrigin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 4:51 PM
 */
@Configuration
public class CORSConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//允许来自hanxiaocu.cn 的跨域请求，api/** 下的任意接口
				registry.addMapping("/api/**").allowedOrigins("https://hanxiaocu.cn");
			}
		};
	}

}
