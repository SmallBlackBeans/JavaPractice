package com.hanxiaocu.eureka.feign.controller;

import com.hanxiaocu.eureka.feign.service.HelloApi;
import com.hanxiaocu.eureka.feign.service.IHelloClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: feign 示例
 * @author: hanchenghai
 * @date: 2018/11/09 2:16 PM
 */
@RestController
@Slf4j
public class DemoController {


	// @Autowired
	// IHelloClient helloClient;

	@Autowired
	HelloApi helloApi;


	// @GetMapping("/hello")
	// public String hello(String name){
	// 	log.info("使用feign调用服务,参数name:{}",name);
	// 	return helloClient.hello(name);
	// }


	@GetMapping("/hello2")
	public String hello2(String name){
		log.info("使用feign继承方式调用服务,参数name:{}",name);
		return helloApi.hello(name);
	}




}
