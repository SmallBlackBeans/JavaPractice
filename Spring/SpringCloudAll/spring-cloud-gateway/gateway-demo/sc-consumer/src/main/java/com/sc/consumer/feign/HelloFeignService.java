package com.sc.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/18 2:16 PM
 */
@FeignClient(name = "producer", fallback = HelloFeignProviderHystrix.class)
public interface HelloFeignService {

	/**
	 * @param name
	 * @return
	 */
	@GetMapping("/hello")
	String hello(@RequestParam(value = "name") String name);

}
