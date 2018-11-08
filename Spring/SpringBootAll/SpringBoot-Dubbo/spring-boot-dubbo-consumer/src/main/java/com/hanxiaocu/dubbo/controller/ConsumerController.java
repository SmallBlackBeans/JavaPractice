package com.hanxiaocu.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hanxiaocu.dubbo.api.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/07 5:47 PM
 */
@RestController
@Slf4j
public class ConsumerController {
	/**
	 * 申明为一个reference，其实就是设置一个bean类了，
	 * 将原来xml配置替换成注解而已
	 * <dubbo:reference id=“xxxService” interface=“com.xxx.XxxService” />
	 */
	@Reference(version = "1.0.0")
	IHelloService helloService;

	@GetMapping("/hello")
	public String hello(String name) {
		log.info("调用提供者服务，参数name：{}", name);
		return helloService.hello(name);
	}

}
