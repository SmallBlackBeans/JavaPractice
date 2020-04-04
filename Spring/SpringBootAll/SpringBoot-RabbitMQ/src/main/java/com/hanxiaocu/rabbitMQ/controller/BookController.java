package com.hanxiaocu.rabbitMQ.controller;

import com.hanxiaocu.rabbitMQ.biz.Book;
import com.hanxiaocu.rabbitMQ.component.BookHandler;
import com.hanxiaocu.rabbitMQ.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20 9:42 AM
 */
@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

	private final RabbitTemplate rabbitTemplate;

	@Autowired
	public BookController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}


	@GetMapping
	public void defaultMessage(){
		Book book = new Book();
		book.setId("1");
		book.setName("一起来学Spring Boot");
		this.rabbitTemplate.convertAndSend(RabbitConfig.DEFAULT_BOOK_QUEUE,book);
		this.rabbitTemplate.convertAndSend(RabbitConfig.MANUAL_BOOK_QUEUE,book);
	}


	/**
	 * this.rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE, RabbitConfig.DELAY_ROUTING_KEY, book); 对应 {@link BookHandler#listenerDelayQueue}
	 */
	@GetMapping
	public void delayMessage() {
		Book book = new Book();
		book.setId("1");
		book.setName("一起来学Spring Boot");

		// 发送消息到延迟exchange中的延迟队列，5秒没人处理就成为了死信，然后就会转发到指定的dlxExchange ,交给正常的路由队列
		this.rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE_NAME, RabbitConfig.DELAY_ROUTING_KEY, book, message -> {
			// TODO 第一句是可要可不要,根据自己需要自行处理
			message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, Book.class.getName());
			// TODO 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
			message.getMessageProperties().setExpiration(5 * 1000 + "");
			return message;
		});
		log.info("[发送时间] - [{}]", LocalDateTime.now());
	}

}

