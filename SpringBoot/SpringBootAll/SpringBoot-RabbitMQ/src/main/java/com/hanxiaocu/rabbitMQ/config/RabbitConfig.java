package com.hanxiaocu.rabbitMQ.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Description:
 * User: hanchenghai
 * Date: 2018/11/01 4:13 PM
 */
@Configuration
public class RabbitConfig {

	/**
	 * 定义一个bbs 队列
	 * @return
	 */
	@Bean
	public Queue bbsQueue() {
		Queue bbs = new Queue("bbs");
		return bbs;
	}

}
