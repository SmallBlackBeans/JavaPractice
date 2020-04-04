package com.sc.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.zip.CheckedOutputStream;

/**
 * @desc: 统计某个或者某种路由的处理时长
 * @author: hanchenghai
 * @date: 2018/12/18 2:31 PM
 */
@Slf4j
public class CustomFilter implements GatewayFilter, Ordered {

	public static final String COUNT_Start_TIME = "countStartTime";

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		exchange.getAttributes().put(COUNT_Start_TIME, System.currentTimeMillis());
		return chain.filter(exchange).then(
				Mono.fromRunnable(() -> {
					Long startTime = exchange.getAttribute(COUNT_Start_TIME);
					Long endTime = System.currentTimeMillis() - startTime;
					if (startTime != null) {
						log.info(exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
					}
				})
		);
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}
}
