package com.hanxiaocu.eureka.provider.api.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/09 2:29 PM
 */
public interface IHelloApi {

	//服务提供者名
	public static final String SERVICE_NAME = "eureka-provider-client";

	/**
	 * 定义接口
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name);
}
