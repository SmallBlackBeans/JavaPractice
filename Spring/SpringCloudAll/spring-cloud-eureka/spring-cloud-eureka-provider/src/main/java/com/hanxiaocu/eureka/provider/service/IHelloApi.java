package com.hanxiaocu.eureka.provider.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.RequestWrapper;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/09 12:31 PM
 */
public interface IHelloApi {


	//服务提供者名
	public static final String SERVICE_NAME="eureka-provider-client";


	@RequestMapping(value = "/helloApi", method = RequestMethod.GET)
	public String helloApi(@RequestParam("name") String name);
}
