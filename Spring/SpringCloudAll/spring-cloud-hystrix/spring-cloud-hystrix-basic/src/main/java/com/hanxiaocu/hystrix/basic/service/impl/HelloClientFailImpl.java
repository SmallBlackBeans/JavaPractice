package com.hanxiaocu.hystrix.basic.service.impl;

import com.hanxiaocu.hystrix.basic.service.IHelloClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/09 4:28 PM
 */
@Component("fallback")
@Slf4j
public class HelloClientFailImpl  implements IHelloClient {
	@Override
	public String hello(String name) {
		log.error("restTemplate调用[hello]服务发生熔断，参数name:{}", name);
		return "restTemplate调用[hello]服务发生熔断，参数name:" + name;
	}
}
