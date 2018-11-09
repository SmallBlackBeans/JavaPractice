package com.hanxiaocu.eureka.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc: 声明式调用
 * @author: hanchenghai
 * @date: 2018/11/09 2:14 PM
 */
//声明时调用指定的服务，不用再去代码里硬编码服务id
// @FeignClient(name = "eureka-provider-client")
public interface IHelloClient {
	/**
	 * 定义接口
	 *
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name);

}
