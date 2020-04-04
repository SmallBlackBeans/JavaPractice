package com.hanxiaocu.zuul.service.controller;

import com.hanxiaocu.zuul.service.bean.DemoReq;
import com.hanxiaocu.zuul.service.bean.DemoResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 3:52 PM
 */
@Api(tags = "service-one 服务")
@RestController
@Slf4j
public class DemoController {
	@GetMapping("/hello")
	@ApiOperation(value = "demo示例")
	public DemoResp hello(DemoReq demoReq) {
		log.info("DemoReq:{}", demoReq);
		return DemoResp.builder()
				.code(demoReq.getCode())
				.name(demoReq.getName())
				.remark(demoReq.getRemark())
				.build();
	}
}
