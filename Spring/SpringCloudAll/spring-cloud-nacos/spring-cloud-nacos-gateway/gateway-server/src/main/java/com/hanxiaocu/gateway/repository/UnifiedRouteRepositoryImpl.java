package com.hanxiaocu.gateway.repository;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/22 3:36 PM
 */
public class UnifiedRouteRepositoryImpl  implements RouteDefinitionRepository {
	@Override
	public Flux<RouteDefinition> getRouteDefinitions() {
		return null;
	}

	@Override
	public Mono<Void> save(Mono<RouteDefinition> route) {
		return null;
	}

	@Override
	public Mono<Void> delete(Mono<String> routeId) {
		return null;
	}
}
