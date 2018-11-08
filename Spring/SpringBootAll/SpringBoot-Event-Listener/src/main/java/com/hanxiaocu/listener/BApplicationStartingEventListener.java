package com.hanxiaocu.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @desc: 启动事件
 * @author: hanchenghai
 * @date: 2018/11/08 2:28 PM
 */
public class BApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		// TODO Auto-generated method stub
		//这时候的bean 还没有加载
		//由于 log相关还未加载 使用了也输出不了的
		// log.info("ApplicationStartingEvent事件发布:{}", event);
		System.out.println("ApplicationStartingEvent事件发布:" + event.getTimestamp());

	}
}
