// package com.hanxiaocu.gateway.config;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
// /**
//  * @desc:
//  * @author: hanchenghai
//  * @date: 2018/11/22 4:44 PM
//  */
// @EnableWebSecurity
// @Configuration
// public class WebConfig extends WebSecurityConfigurerAdapter {
// 	@Override
// 	public void configure(HttpSecurity http) throws Exception {
// 		http.authorizeRequests()
// 				.anyRequest().authenticated()
// 				.and()
// 				.formLogin()
// 				.and()
// 				.httpBasic();
// 	}
// }
