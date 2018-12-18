package com.sc.gateway.route;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 路由
 * @author: hanchenghai
 * @date: 2018/12/18 3:33 PM
 */
@Setter
@Getter
public class GatewayRouteDefinition {
	/**
	 * 路由ID
	 */
	private String id;

	/// 路由断言集合配置
	private List<GatewayPredicateDefinition> predicates = new ArrayList<>();

	/// 过滤器集合配置
	private List<GatewayFilterDefinition> filters = new ArrayList<>();

	/// 路由规则转发的目标uri
	private String uri;

	/// 路由执行的顺序
	private int order = 0;


}
