package com.hanxiaocu.jwt.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @desc: 编码
 * @author: hanchenghai
 * @date: 2018/11/14 5:34 PM
 */
@Configuration
public class PasswordEncoderConfig {

	@Bean
	protected BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
