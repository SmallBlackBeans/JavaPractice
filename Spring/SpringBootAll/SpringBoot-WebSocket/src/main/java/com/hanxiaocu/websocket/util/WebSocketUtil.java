package com.hanxiaocu.websocket.util;

import javax.websocket.RemoteEndpoint;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 5:34 PM
 */
public class WebSocketUtil {

	private static final Map<String, Session> ONLINE_SESSION = new ConcurrentHashMap<>();


	public static void addSession(String usernick, Session session) {
		ONLINE_SESSION.putIfAbsent(usernick, session);
	}

	public static void removeSession(String usernick) {
		ONLINE_SESSION.remove(usernick);
	}

	/**
	 * 向某个用户发消息
	 * @param session
	 * @param message
	 */
	public static void sendMessage(Session session, String message) {
		if (session == null) {
			return;
		}
		Async async = session.getAsyncRemote();
		async.sendText(message);
	}

	public static void sendMessageToAll(String message) {
		ONLINE_SESSION.forEach((sessionid,seesion) -> {
			sendMessage(seesion,message);
		});
	}
}
