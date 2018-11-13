package com.hanxiaocu.ws.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/13 1:00 PM
 */
@RestController
public class DemoController {

	@GetMapping("/")
	public String hello(){
		return "xxx";
	}
}
