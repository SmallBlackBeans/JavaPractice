package com.hanxiaocu;

import com.hanxiaocu.listener.BApplicationStartingEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/08 2:13 PM
 */
@SpringBootApplication
@EnableAsync
@Slf4j
public class Application {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		//加入自定义监听器
		application.addListeners(new BApplicationStartingEventListener());
		application.run(args);
	}
}
