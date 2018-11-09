package com.hanxiaocu.eureka.provider.controller;

import com.hanxiaocu.eureka.provider.service.IHelloApi;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/08 5:10 PM
 */
@RestController
@Slf4j
public class DemoController implements IHelloApi {


	@GetMapping("/")
	public String index() {
		return "spring-cloud-eureka-provider!";
	}

	@Override
	public String helloApi(@RequestParam("name") String name) {
		log.info("[spring-cloud-eureka-provider]服务[helloApi]被调用，参数name值为：{}", name);
		return name + " , this is spring-cloud-eureka-provider-client !";
	}
}
