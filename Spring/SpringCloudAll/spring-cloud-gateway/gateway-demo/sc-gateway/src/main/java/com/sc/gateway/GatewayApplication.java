package com.sc.gateway;

import com.sc.gateway.filter.CustomFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/18 2:03 PM
 */
@SpringBootApplication
@Slf4j
public class GatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
		log.debug("gateway 启动...");
	}

	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r ->
						//可以把对外暴露的URL通过加前缀分组打标
						r.path("/test/prefix/**")
						.filters(f ->
								f.stripPrefix(2)
								.filter(new CustomFilter())
								.addRequestHeader("X-Response-test", "test"))
						.uri("lb://SC-CONSUMER")
						.order(0)
						.id("test_consumer_service")
				).build();

	}
}
