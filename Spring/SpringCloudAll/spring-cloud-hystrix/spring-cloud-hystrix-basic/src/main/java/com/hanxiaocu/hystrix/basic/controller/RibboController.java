package com.hanxiaocu.hystrix.basic.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/09 3:37 PM
 */
@RestController
@Slf4j
public class RibboController {

	@Autowired
	RestTemplate restTemplate;


	//http://localhost:8021/ribbon?name=nihao
	@GetMapping("/ribbon")
	/**
	 *  命令
	 *  每个命令在独立线程中执行
	 * fallbackMethod 以此实现调用方法发生异常或者错误时，可以快速返回，避免持续请求，造成资源的耗
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	public String ribbon(String name) {
		log.info("使用restTemplate 调用服务，参数：{}", name);
		return restTemplate.getForObject("http://eureka-provider-client/hello?name=" + name, String.class);
	}

	/**
	 * 发生熔断时调用的方法
	 *
	 * @param name
	 * @param throwable
	 * @return
	 */
	public String fallback(String name, Throwable throwable) {
		log.error("熔断发生了：{}", throwable);
		log.warn("restTemplate 调用服务发生熔断,参数name:{}", name);
		return "restTemplate调用服务发生熔断，参数name：" + name;
	}

}
