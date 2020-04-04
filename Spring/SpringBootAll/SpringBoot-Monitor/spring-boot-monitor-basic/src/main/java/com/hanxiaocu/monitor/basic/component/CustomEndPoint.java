package com.hanxiaocu.monitor.basic.component;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/06 4:54 PM
 */
@Endpoint(id = "bbs-custom")
@Component
public class CustomEndPoint {
	@ReadOperation
	public Map<String, Object> custom() {
		Map<String, Object> result = new HashMap<>();
		result.put("author", "BBS");
		result.put("age", "26");
		result.put("email", "374802597@qq.com");
		return result;
	}
}
