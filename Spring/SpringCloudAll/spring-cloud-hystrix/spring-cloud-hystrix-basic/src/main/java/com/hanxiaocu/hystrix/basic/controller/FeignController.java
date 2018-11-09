package com.hanxiaocu.hystrix.basic.controller;

import com.hanxiaocu.hystrix.basic.service.IHelloClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: feign 熔断器示例
 * @author: hanchenghai
 * @date: 2018/11/09 4:32 PM
 */
@RestController
@Slf4j
public class FeignController {


	@Autowired
	IHelloClient helloClient;


	//http://localhost:8021/feign?name=nihao
	@GetMapping("/feign")
	public String hello(String name) {
		log.info("使用feign调用服务，参数name:{}", name);
		return helloClient.hello(name);
	}
}
