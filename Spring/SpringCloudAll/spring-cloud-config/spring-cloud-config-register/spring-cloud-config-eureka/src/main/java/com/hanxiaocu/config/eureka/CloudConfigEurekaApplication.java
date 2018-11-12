package com.hanxiaocu.config.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 11:11 AM
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class CloudConfigEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigEurekaApplication.class, args);
		log.info("spring-cloud-config-eureka 注册中心 启动！");
	}

	/**
	 * 忽略此路径下的CSRF令牌 跨域访问
	 */
	@EnableWebSecurity
	static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().ignoringAntMatchers("/eureka/**");
			super.configure(http);
		}
	}
}