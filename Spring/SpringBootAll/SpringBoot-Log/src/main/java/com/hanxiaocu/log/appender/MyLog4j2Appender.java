// package com.hanxiaocu.log.appender;
//
// import org.apache.logging.log4j.core.Filter;
// import org.apache.logging.log4j.core.Layout;
// import org.apache.logging.log4j.core.LogEvent;
// import org.apache.logging.log4j.core.appender.AbstractAppender;
// import org.apache.logging.log4j.core.config.plugins.Plugin;
// import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
// import org.apache.logging.log4j.core.config.plugins.PluginElement;
// import org.apache.logging.log4j.core.config.plugins.PluginFactory;
// import org.apache.logging.log4j.core.layout.PatternLayout;
//
// import java.io.Serializable;
//
// /**
//  * @desc: 自定义log4j2 输出源
//  * @author: hanchenghai
//  * @date: 2018/11/06 11:52 AM
//  */
// //这里的 MyLog4j2 对应就是 xml中，
//
// /**
//  * <appenders>
//  * <MyLog4j2 name="customAppender" printString="一枚趔趄的猿">
//  * </MyLog4j2>
//  * </appenders>
//  */
//
// @Plugin(name = "MyLog4j2", category = "Core", elementType = "appender", printObject = true)
// public class MyLog4j2Appender extends AbstractAppender {
//
// 	String printString;
//
// 	public MyLog4j2Appender(String name, Filter filter, Layout<? extends Serializable> layout, String printString) {
// 		super(name, filter, layout);
// 		this.printString = printString;
// 	}
//
// 	@Override
// 	public void append(LogEvent logEvent) {
// 		if (logEvent != null && logEvent.getMessage() != null) {
// 			// 这里面需要实现具体的逻辑，日志的去向。
//
// 			// 此处自定义实现输出
// 			// 获取输出值：event.getMessage().toString()
// 			// System.out.print(event.getMessage().toString());
// 			// 格式化输出
// 			System.out.print(printString + "：" + getLayout().toSerializable(logEvent));
// 		}
//
// 	}
//
// 	/**
// 	 * 接收配置文件中的参数
// 	 *
// 	 * @PluginAttribute 字面意思都知道，是xml节点的attribute值，如<BBS name="xxx"></BBS> 这里的name 就是 attribute
// 	 * @PluginElement：表示xml子节点的元素， 如
// 	 * <BBS name="bbs">
// 	 * <PatternLayout pattern="[%d{HH:mm:ss:SSS}] [%p] - %l - %m%n"/>
// 	 * </BBS>
// 	 * 其中，PatternLayout就是{@link Layout}的实现类。
// 	 */
// 	@PluginFactory
// 	public static MyLog4j2Appender createAppender(
// 			@PluginAttribute("name") String name,
// 			@PluginElement("Filter") final Filter filter,
// 			@PluginElement("Layout") Layout<? extends Serializable> layout,
// 			@PluginAttribute("printString") String printString) {
//
// 		if (name == null) {
// 			LOGGER.error("no name defined in conf.");
// 			return null;
// 		}
// 		//默认使用 PatternLayout
// 		if (layout == null) {
// 			layout = PatternLayout.createDefaultLayout();
// 		}
//
// 		return new MyLog4j2Appender(name, filter, layout, printString);
// 	}
//
// 	@Override
// 	public void start() {
// 		System.out.println("log4j2-start方法被调用");
// 		super.start();
// 	}
//
// 	@Override
// 	public void stop() {
// 		System.out.println("log4j2-stop方法被调用");
// 		super.stop();
// 	}
//
// }
