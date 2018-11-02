package com.hanxiaocu.webapp.CrossOrigin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 整个控制层所有的映射方法都支持跨域请求。
 * @author: hanchenghai
 * @date: 2018/11/02 4:49 PM
 */
@CrossOrigin(origins = "http://www.baicu.com",maxAge = 3600)
@RestController
public class CrossOriginController {

	@GetMapping("/")
	public String index() {
		return "hello,CORS";
	}
}
