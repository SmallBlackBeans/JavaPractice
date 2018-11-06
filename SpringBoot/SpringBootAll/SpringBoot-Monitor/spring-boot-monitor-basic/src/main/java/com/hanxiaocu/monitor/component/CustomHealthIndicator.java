package com.hanxiaocu.monitor.component;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @desc: 自定义健康端点
 * @author: hanchenghai
 * @date: 2018/11/06 4:40 PM
 */
@Component
public class CustomHealthIndicator  extends AbstractHealthIndicator {
	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {

		builder.withDetail("code","1234")
				.withDetail("version","v0.1")
				.up().build();

	}
}
