package com.hanxiaocu.rabbitMQ.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Desc:
 * Date: 2018/11/01 4:18 PM
 *
 * @author hanchenghai
 */
@Component
@Slf4j
// 监听我们写的那个队列
@RabbitListener(queues = "bbs")
public class Consumer {

	/**
	 * @RabbitHandler 指定消息的处理方法
	 * @param message
	 */
	@RabbitHandler
	public void process(String message) {
		log.info("接收到消息为： {}",message);

	}

}
