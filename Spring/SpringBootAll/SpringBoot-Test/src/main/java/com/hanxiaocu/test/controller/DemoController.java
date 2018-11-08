package com.hanxiaocu.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/01 5:07 PM
 */
@RestController
public class DemoController {


	@GetMapping("/mock")
	public String demo(String msg) {
		return msg;
	}

}
