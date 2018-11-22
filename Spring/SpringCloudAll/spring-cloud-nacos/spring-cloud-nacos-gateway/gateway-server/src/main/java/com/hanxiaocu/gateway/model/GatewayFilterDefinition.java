package com.hanxiaocu.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc: 过滤器模型
 * @author: hanchenghai
 * @date: 2018/11/22 2:32 PM
 */
@Setter
@Getter
public class GatewayFilterDefinition {
	/**
	 * 过滤器名
	 */
	private String name;

	/**
	 * 对应的路由规则
	 */
	private Map<String, String> args = new LinkedHashMap<>();

}
