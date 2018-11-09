package com.hanxiaocu.eureka.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @desc: 服务消费者 示例
 * @author: hanchenghai
 * @date: 2018/11/09 10:07 AM
 */
@RestController
@Slf4j
public class DemoController {

	@Autowired
	private RestTemplate template;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@GetMapping("/")
	public String index() {
		//访问服务提供者
		return template.getForObject("http://eureka-provider-client/", String.class);
	}

	@GetMapping("/hello")
	public String hello(String name) {
		//寻找一个服务提供者
		ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-PROVIDER-CLIENT");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello?name=" + name;
		log.info("url 地址为：{}", url);
		return template.getForObject(url,String.class);
	}

}
