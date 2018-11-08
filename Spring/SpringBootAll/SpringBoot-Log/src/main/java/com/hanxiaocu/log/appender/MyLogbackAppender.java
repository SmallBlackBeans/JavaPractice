package com.hanxiaocu.log.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import lombok.Getter;
import lombok.Setter;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 2:18 PM
 */
@Getter
@Setter
public class MyLogbackAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {


	Layout<ILoggingEvent> layout;

	String printString;

	@Override
	public void start() {
		//这里可以做些初始化判断 比如layout不能为null ,
		if(layout == null) {
			addWarn("Layout was not defined");
		}
		//或者写入数据库 或者redis时 初始化连接等等
		super.start();
		//配置一个ShutdownHook系统钩子，使得在jvm在退出时之前会调用
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				// 执行资源释放操作
			}
		}));
	}

	@Override
	public void stop() {
		//释放相关资源，如数据库连接，redis线程池等等
		if(!isStarted()) {
			return;
		}
		System.out.println("logback-stop方法被调用");
		super.stop();
	}

	@Override
	protected void append(ILoggingEvent event) {
		if (event == null || !isStarted()){
			return;
		}
		// 此处自定义实现输出
		// 获取输出值：event.getFormattedMessage()
		// System.out.print(event.getFormattedMessage());
		// 格式化输出
		System.out.print(printString + "：" + layout.doLayout(event));

	}
}
