package com.hanxiaocu.config;

import com.hanxiaocu.entity.MessageEntity;
import com.hanxiaocu.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @desc: 配置监听类 使用@EventListener方式
 * @author: hanchenghai
 * @date: 2018/11/08 2:17 PM
 */
@Configuration
@Slf4j
public class EventListenerConfig {


	@EventListener
	public void handleEvent(Object event) {
		//监听所有事件
		//可根据 instanceof 监听想要监听的事件
		// if(event instanceof CustomEvent) {
		//
		// }
		log.info("事件：{}",event);
	}

	@EventListener
	public void handleCustomEvent(CustomEvent customEvent) {
		//监听 CustomEvent事件
		log.info("监听到CustomEvent事件，消息为：{}, 发布时间：{}", customEvent.getMessageEntity(), customEvent.getTimestamp());
	}

	/**
	 * 监听 code为BBS的事件
	 * SpEL 表达式
	 */
	//异步监听事件
	@Async
	@EventListener(condition="#customEvent.messageEntity.code == 'BBS'")
	public void handleCustomEventByCondition(CustomEvent customEvent) {
		//监听 CustomEvent事件
		log.info("监听到code为'BBS'的CustomEvent事件，消息为：{}, 发布时间：{}", customEvent.getMessageEntity(), customEvent.getTimestamp());
	}

	@EventListener
	public void handleObjectEvent(MessageEntity messageEntity) {
		//这个和eventbus post方法一样了
		log.info("监听到对象事件，消息为：{}", messageEntity);

	}
}
