package com.hanxiaocu.springbootlock.localLock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20 3:31 PM
 */
@RestController
@RequestMapping("/books")
public class BookController {


	@LocalLock(key = "book:arg[0]")
	@GetMapping
	public String query(@RequestParam String token){
		return "success - " + token;
	}
}
