package com.hanxiaocu.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 11:42 AM
 */
@RestController
@RefreshScope//使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class DemoController {

	@Value("${config}")
	String config;

	//http://127.0.0.1:5666/
	@GetMapping("/")
	public String demo() {
		return "返回的config参数值为:" + config;
	}
}

