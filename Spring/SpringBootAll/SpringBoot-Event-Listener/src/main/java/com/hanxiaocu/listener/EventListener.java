package com.hanxiaocu.listener;

import com.hanxiaocu.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @desc: 使用ApplicationListener方式 监听
 * @author: hanchenghai
 * @date: 2018/11/08 2:22 PM
 */
@Component
@Slf4j
public class EventListener implements ApplicationListener<CustomEvent> {
	@Override
	public void onApplicationEvent(CustomEvent event) {
		//这里也可以监听所有事件 使用  ApplicationEvent 类即可
		//这里仅仅监听自定义事件 CustomEvent
		log.info("ApplicationListener方式监听事件：{}", event);
	}
}
