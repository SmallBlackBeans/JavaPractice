package com.hanxiaocu.eureka.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/08 5:10 PM
 */
@RestController
public class DemoController {


	@GetMapping("/")
	public String index() {
		return "spring-cloud-eureka-provider!";
	}
}
