package com.hanxiaocu.gateway.route;

import com.alibaba.fastjson.JSON;
import com.hanxiaocu.gateway.model.GatewayPredicateDefinition;
import com.hanxiaocu.gateway.model.GatewayRouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 动态路由实现类
 * @author: hanchenghai
 * @date: 2018/11/22 2:38 PM
 */
@Service
public class DynamicRouteServiceImpl implements ApplicationEventPublisherAware {

	@Autowired
	private RouteDefinitionWriter routeDefinitionWriter;
	private ApplicationEventPublisher publisher;

	private static final String SUCCESS = "success";

	/**
	 * 增加路由
	 *
	 * @param definition
	 * @return
	 */
	public String add(RouteDefinition definition) {
		routeDefinitionWriter.save(Mono.just(definition)).subscribe();
		this.publisher.publishEvent(new RefreshRoutesEvent(this));
		return SUCCESS;
	}

	/**
	 * 更新路由
	 *
	 * @param definition
	 * @return
	 */
	public String update(RouteDefinition definition) {
		try {
			routeDefinitionWriter.delete(Mono.just(definition.getId()));
		} catch (Exception e) {
			return "update fial, not find route routeId: " + definition.getId();
		}

		try {
			routeDefinitionWriter.save(Mono.just(definition)).subscribe();
			publisher.publishEvent(new RefreshRoutesEvent(this));
			return SUCCESS;
		} catch (Exception e) {
			return "update route fail";
		}
	}

	/**
	 * 删除路由
	 *
	 * @param id
	 * @return
	 */
	// public Mono<ResponseEntity<Object>> delete(String id) {
	// 	return this.routeDefinitionWriter.delete(Mono.just(id))
	// 			.then(Mono.defer(() -> Mono.just(ResponseEntity.ok().build())))
	// 			.onErrorResume(t -> t instanceof NotFoundException, t -> Mono.just(ResponseEntity.notFound().build()));
	// }

	public String delete(String id) {
		try {
			this.routeDefinitionWriter.delete(Mono.just(id));
			return "delete success";
		} catch (Exception e) {
			e.printStackTrace();
			return "delete fail";
		}

	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	/**
	 * * spring:
	 * cloud:
	 * gateway:
	 * routes: #当访问http://localhost:8080/baidu,直接转发到https://www.baidu.com/
	 * - id: baidu_route
	 * uri: http://baidu.com:80/
	 * predicates:
	 * - Path=/baidu
	 * * @param args
	 */
	public static void main(String[] args) {

		GatewayRouteDefinition definition = new GatewayRouteDefinition();
		GatewayPredicateDefinition predicate = new GatewayPredicateDefinition();
		Map<String,String> predicateParams = new HashMap<>(8);
		definition.setId("jd_route");
		predicate.setName("Path");
		predicateParams.put("pattern","/jd");
		predicate.setArgs(predicateParams);
		definition.setPredicates(Collections.singletonList(predicate));
		String uri = "http://www.jd.com";
		definition.setUri(uri);
		System.out.println("definition:" + JSON.toJSONString(definition));

		RouteDefinition definition1 = new RouteDefinition();
		PredicateDefinition predicate1 = new PredicateDefinition();
		Map<String, String> predicateParams1 = new HashMap<>(8);
		definition1.setId("baidu_route");
		predicate1.setName("Path");
		predicateParams1.put("pattern", "/baidu");
		predicate1.setArgs(predicateParams1);
		definition1.setPredicates(Arrays.asList(predicate1));
		URI uri1 = UriComponentsBuilder.fromHttpUrl("http://www.baidu.com").build().toUri();
		definition1.setUri(uri1);
		System.out.println("definition1："+JSON.toJSONString(definition1));

	}
}
