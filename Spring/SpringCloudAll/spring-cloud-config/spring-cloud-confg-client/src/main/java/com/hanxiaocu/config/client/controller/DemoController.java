package com.hanxiaocu.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: client 示例
 * @author: hanchenghai
 * @date: 2018/11/12 10:53 AM
 */
@RestController
public class DemoController {

	@Value("${spring.cloud.config}")
	String config;

	@GetMapping("/")
	public String demo(){
		return "返回config参数：" + config;
	}
}
