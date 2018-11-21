package com.hanxiaocu.springbootlimiter.limeter.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/21 4:48 PM
 */
//表明是配置类
@Configuration
//启用AspectJ自动代理
@EnableAspectJAutoProxy
@ComponentScan("com.hanxiaocu")
public class Limit_Aop_Config {

	@Bean
	public LimitInterceptor interceptor() {
		return new LimitInterceptor(null);
	};

}
