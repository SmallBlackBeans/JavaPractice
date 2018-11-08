package com.hanxiaocu.rabbitMQ.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 发送和接收队列消息
 *
 * @author: hanchenghai
 * @date: 2018/11/01 4:23 PM
 */
@RestController
public class DemoController {


	@Autowired
	AmqpTemplate rabbitmqTemplate;

	//http://127.0.0.1:8080/send?msg=hello,rabbitmq
	@GetMapping("/send")
	public String send(String msg){
		rabbitmqTemplate.convertAndSend("bbs",msg);
		return "消息: " + msg + "，已发送";
	}

}
