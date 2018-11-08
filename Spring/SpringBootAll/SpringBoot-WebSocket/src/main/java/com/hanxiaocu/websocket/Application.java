package com.hanxiaocu.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @desc: 聊天室
 *
 * 测试地址：http://coolaf.com/tool/chattest
 * ws://127.0.0.1:8080/my-chat/xiaoheidou
 * @author: hanchenghai
 * @date: 2018/11/02 5:28 PM
 */
@Slf4j
@SpringBootApplication
@EnableWebSocket
public class Application {
	public static void main(String[] args) {
		new SpringApplication(Application.class).run(args);
		log.info("聊天室启动了...");
	}

	/**
	 * 会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
	 * 要注意，如果使用独立的servlet容器，
	 * 而不是直接使用springboot的内置容器，
	 * 就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理。
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}

