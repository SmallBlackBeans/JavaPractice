package com.sc.gateway.route;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc: 断言定义模型
 * @author: hanchenghai
 * @date: 2018/12/18 3:33 PM
 */
public class GatewayPredicateDefinition {
	private String name;
	private Map<String, String> args = new LinkedHashMap<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}
}
