package com.sc.gateway.route;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc: 过滤器
 * @author: hanchenghai
 * @date: 2018/12/18 3:34 PM
 */
public class GatewayFilterDefinition {
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