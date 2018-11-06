package com.hanxiaocu.aop.controller;

import com.hanxiaocu.aop.annotation.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 11:34 AM
 */
@RestController
public class DemoController {

	/**
	 * 简单示例
	 *
	 * @param hello
	 * @return
	 */
	@RequestMapping("/aop")
	@Log(value = "请求了aopDemo方法")
	public String aopDemo(String hello) {
		return "请求参数" + hello;

	}

	/**
	 * 不拦截日志示例
	 *
	 * @param hello
	 * @return
	 */
	@RequestMapping("/notaop")
	@Log(ignore = true)
	public String notAopDemo(String hello) {
		return "请求参数" + hello;
	}

}
