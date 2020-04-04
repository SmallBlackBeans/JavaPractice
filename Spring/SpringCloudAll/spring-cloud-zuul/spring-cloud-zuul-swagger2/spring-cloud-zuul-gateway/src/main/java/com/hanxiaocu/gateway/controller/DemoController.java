package com.hanxiaocu.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 5:05 PM
 */
@RestController
@RequestMapping("/demo")
@Api(tags = "zuul 内部 rest api")
public class DemoController {

	@GetMapping("/hello")
	@ApiOperation(value = "demo示例",notes = "demo示例")
	//隐式的参数
	@ApiImplicitParam(name = "name",value = "名称",example = "hanxiaocu")
	public String hello(String name) {
		return "hi," + name + ",this is zuul api! ";
	}
}
