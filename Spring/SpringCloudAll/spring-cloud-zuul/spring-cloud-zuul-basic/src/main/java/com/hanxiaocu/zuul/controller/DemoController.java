package com.hanxiaocu.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 1:55 PM
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hi, " + name + ", this is zuul api!";
	}

}
