package com.hanxiaocu.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 10:07 AM
 */
@RestController
public class DemoController {

	@GetMapping("/")
	public String demo() {
		return "hello, hanxiaocu,  welcome to docker!";
	}
}
