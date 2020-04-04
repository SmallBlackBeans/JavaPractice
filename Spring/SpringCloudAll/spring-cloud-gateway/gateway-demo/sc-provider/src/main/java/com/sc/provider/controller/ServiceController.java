package com.sc.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/18 3:03 PM
 */
@RestController
public class ServiceController {

	// produces  指定响应类型
	@RequestMapping(value = "/v1",produces = "text/plain;charset=UTF-8")
	public Mono<String> v1() {
		return Mono.just("v1");
	}

	@RequestMapping(value = "/v2",produces = "text/plain;charset=UTF-8")
	public Mono<String>v2() {
		return Mono.just("v2");
	}
}
