package com.hanxiaocu.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 11:42 AM
 */
@RestController
public class DemoController {

	@Value("${config}")
	String config;

	@GetMapping("/")
	public String demo() {
		return "返回的config参数值为:" + config;
	}
}

