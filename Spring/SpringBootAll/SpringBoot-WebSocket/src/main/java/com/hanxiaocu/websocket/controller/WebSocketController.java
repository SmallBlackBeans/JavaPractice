package com.hanxiaocu.websocket.controller;

import com.hanxiaocu.websocket.util.WebSocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @desc: 简易聊天
 * @author: hanchenghai
 * @date: 2018/11/02 5:30 PM
 */
//由于是websocket 所以原本是@RestController的http形式
//直接替换成@ServerEndpoint即可，作用是一样的 就是指定一个地址
//表示定义一个websocket的Server端
@Component
@ServerEndpoint(value = "/my-chat/{usernick}")
@Slf4j
public class WebSocketController {

	@OnOpen
	public void onOpen(@PathParam(value = "usernick")String usernick, Session session) {
		String message = "有新游客[" + usernick + "]加入聊天室!";
		log.info(message);

		WebSocketUtil.addSession(usernick,session);
		WebSocketUtil.sendMessageToAll(message);
	}

	@OnClose
	public void onClose(@PathParam(value = "usernick") String userNick,Session session) {
		String message = "游客[" + userNick + "]退出聊天室!";
		log.info(message);
		WebSocketUtil.removeSession(userNick);
		WebSocketUtil.sendMessageToAll(message);
	}

	@OnMessage
	public void OnMessage(@PathParam(value = "usernick") String userNick, String message) {
		//类似群发
		String info = "游客[" + userNick + "]：" + message;
		log.info(info);
		WebSocketUtil.sendMessageToAll(message);
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		log.error("异常:", throwable);
		try {
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throwable.printStackTrace();
	}
}
