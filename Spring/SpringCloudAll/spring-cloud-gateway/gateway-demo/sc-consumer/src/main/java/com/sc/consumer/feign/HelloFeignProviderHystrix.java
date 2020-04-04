package com.sc.consumer.feign;

import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/18 2:17 PM
 */
@Component
public class HelloFeignProviderHystrix implements HelloFeignService {

	@Override
	public String hello(String name) {
		return "hello world!";
	}
}
