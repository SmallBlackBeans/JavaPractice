package com.hanxiaocu.springbootlock.redisLock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20 4:54 PM
 */
@RestController
@RequestMapping("/redis/books")
public class BookController {


	@GetMapping
	@CacheLock(prefix = "books")
	public String query(@CacheParam(name = "token") @RequestParam String token) {
		return "success - " + token;
	}
}
