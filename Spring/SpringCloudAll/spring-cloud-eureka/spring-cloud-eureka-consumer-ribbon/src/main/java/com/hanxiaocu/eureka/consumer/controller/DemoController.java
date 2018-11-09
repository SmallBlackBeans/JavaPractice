package com.hanxiaocu.eureka.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @desc: ribbo 客户端示例
 * @author: hanchenghai
 * @date: 2018/11/09 1:22 PM
 */
@RestController
@Slf4j
public class DemoController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hello")
	public String hello(String name) {
		log.info("请求参数：{}", name);
		return restTemplate.getForObject("http://eureka-provider-client/hello?name=" + name, String.class);
	}

}
