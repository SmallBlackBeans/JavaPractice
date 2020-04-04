package com.hanxiaocu.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc: 断言定义模型
 * @author: hanchenghai
 * @date: 2018/11/22 2:32 PM
 */
@Getter
@Setter
public class GatewayPredicateDefinition {
	/**
	 * 断言对应的名字
	 */
	private String name;

	/**
	 * 配置的断言规则
	 */
	private Map<String, String> args = new LinkedHashMap<>();
}
