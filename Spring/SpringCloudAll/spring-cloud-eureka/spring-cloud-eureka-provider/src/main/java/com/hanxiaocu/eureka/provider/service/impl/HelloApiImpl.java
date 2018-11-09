package com.hanxiaocu.eureka.provider.service.impl;

import com.hanxiaocu.eureka.provider.api.Service.IHelloApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/09 2:32 PM
 */
@RestController
@Slf4j
public class HelloApiImpl implements IHelloApi {

	@Override
	public String hello(@RequestParam("name") String name) {
		log.info("服务:[spring-cloud-eureka-provider] --- [helloApi]功能 被调用，参数name值为：{}", name);
		return name + " , this is spring-cloud-eureka-provider-client !";
	}
}
