package com.hanxiaocu.event;

import com.hanxiaocu.entity.MessageEntity;
import org.springframework.context.ApplicationEvent;

/**
 * @desc: 事件源
 * @author: hanchenghai
 * @date: 2018/11/08 2:15 PM
 */
public class CustomEvent extends ApplicationEvent {

	private MessageEntity messageEntity;

	public CustomEvent(Object source, MessageEntity messageEntity) {
		super(source);
		this.messageEntity = messageEntity;
	}

	public MessageEntity getMessageEntity() {
		return messageEntity;
	}
}
