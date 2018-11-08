package com.hanxiaocu.webapp.webjars.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 3:58 PM
 */
@Controller
@RequestMapping("/webjars")
@Slf4j
public class WebJarsDemoController {

	@GetMapping("/index")
	public String index() {
		log.info("webjars.....");
		return "webjars.html";

	}
}
