package com.sc.gateway.controller;

import com.sc.gateway.route.DynamicRouteServiceImpl;
import com.sc.gateway.route.GatewayPredicateDefinition;
import com.sc.gateway.route.GatewayRouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/18 4:04 PM
 */
@RestController
@RequestMapping("/route")
public class RouteController {

	@Autowired
	private DynamicRouteServiceImpl dynamicRouteService;

	@PostMapping("/add")
	public String add(@RequestBody GatewayRouteDefinition gwdefinition) {
		try {
			RouteDefinition definition = assembleRouteDefinition(gwdefinition);
			return this.dynamicRouteService.add(definition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@DeleteMapping("/routes/{id}")
	public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
		return this.dynamicRouteService.delete(id);
	}

	//更新路由
	@PostMapping("/update")
	public String update(@RequestBody GatewayRouteDefinition gwdefinition) {
		RouteDefinition definition = assembleRouteDefinition(gwdefinition);
		return this.dynamicRouteService.update(definition);
	}

	private RouteDefinition assembleRouteDefinition(GatewayRouteDefinition gwdefinition) {
		RouteDefinition definition = new RouteDefinition();
		List<PredicateDefinition> pdList = new ArrayList<>();
		definition.setId(gwdefinition.getId());
		List<GatewayPredicateDefinition> gatewayPredicateDefinitions = gwdefinition.getPredicates();
		for (GatewayPredicateDefinition gpDefinition : gatewayPredicateDefinitions) {
			PredicateDefinition predicate = new PredicateDefinition();
			predicate.setArgs(gpDefinition.getArgs());
			predicate.setName(gpDefinition.getName());
			pdList.add(predicate);
		}

		definition.setPredicates(pdList);
		URI uri = UriComponentsBuilder.fromHttpUrl(gwdefinition.getUri()).build().toUri();
		definition.setUri(uri);
		return definition;
	}
}
