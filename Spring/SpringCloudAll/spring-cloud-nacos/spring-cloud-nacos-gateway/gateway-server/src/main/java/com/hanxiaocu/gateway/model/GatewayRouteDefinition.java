package com.hanxiaocu.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/22 2:31 PM
 */
@Setter
@Getter
public class GatewayRouteDefinition {

	/**
	 * 路由id
	 */
	private String id;

	/**
	 * 路由断言集合配置
	 */
	private List<GatewayPredicateDefinition> predicates = new ArrayList<>();

	/**
	 * 路由过滤器集合配置
	 */
	private List<GatewayFilterDefinition> filters = new ArrayList<>();

	/**
	 * 路由规则转发的目标uri
	 */
	private String uri;
	/**
	 * 路由执行的顺序
	 */
	private int order = 0;
}
