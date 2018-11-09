package com.hanxiaocu.hystrix.basic.service;

import com.hanxiaocu.hystrix.basic.service.component.HelloClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/09 4:24 PM
 */
//两者 同时设置时，优先调用fallback，后者可以提示具体的异常
@FeignClient(name="EUREKA-PROVIDER-CLIENT",/*fallback=HelloClientFailImpl.class,*/ fallbackFactory = HelloClientFallbackFactory.class)
public interface IHelloClient {

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name);
}
