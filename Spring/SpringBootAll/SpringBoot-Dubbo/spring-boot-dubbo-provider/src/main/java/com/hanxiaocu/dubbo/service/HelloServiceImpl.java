package com.hanxiaocu.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.hanxiaocu.dubbo.api.IHelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @desc: 定义一个服务类
 * @author: hanchenghai
 * @date: 2018/11/07 4:56 PM
 */

@Service(version = "${demo.service.version}",//版本   一个接口多版本共存问题
		application = "${dubbo.application.id}",//应用id
		protocol = "${dubbo.protocol.id}",//协议id
		registry = "${dubbo.registry.id}"//注册中心id
)
@Slf4j
public class HelloServiceImpl implements IHelloService {
	@Override
	public String hello(String name) {
		log.info("dubbo 服务提供者, 参数name:{}",name);
		return "hello " + name + ", this is a dubbo provider";
	}
}
