package com.hanxiaocu.netty.webSocket;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/15 4:27 PM
 */
public interface Init {
	int PORT = 8050;
	String HOST = "localhost";
	String WEB_SOCKET_URL = String.format("ws://%s:%d/websocket",HOST,PORT);
}
