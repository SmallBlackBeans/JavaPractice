package com.hanxiaocu.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 2:34 PM
 */
@RestController
@Slf4j
public class DemoController {
	@GetMapping("/")
	public String index() {
		log.info("hello index!");
		return "index";
	}
}
