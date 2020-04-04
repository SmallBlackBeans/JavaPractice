package com.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import org.springframework.cloud.gateway.route.RouteLocator;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class SpringCloudGatewayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r ->
                        r.path("/baidu").uri("http://baidu.com:80/")
                ).build();

    }

    @Bean
    public RouteLocator customAfterRouteLocator(RouteLocatorBuilder builder) {
        ZonedDateTime minusTime = LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault());
        return builder.routes()
                .route("after_route", r ->
                        r.after(minusTime)
                                .uri("http://github.com"))
                .build();
    }

    @Bean
    public RouteLocator customBeforeRouteLocator(RouteLocatorBuilder builder) {
        ZonedDateTime datetime = LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault());
        //@formatter:off
        return builder.routes()
                .route("before_route", r ->
                        r.before(datetime)
                        .uri("http://github.com"))
                .build();
        //@formatter:on
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }

}

