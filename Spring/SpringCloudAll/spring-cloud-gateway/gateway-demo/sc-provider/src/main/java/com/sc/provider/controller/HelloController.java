package com.sc.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/18 2:20 PM
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

	@GetMapping("")
	public String hello(@RequestParam String name) {
		return "hello " + name + "!";
	}
}
