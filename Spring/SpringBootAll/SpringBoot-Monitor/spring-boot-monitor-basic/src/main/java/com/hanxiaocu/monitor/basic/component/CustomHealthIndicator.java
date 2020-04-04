package com.hanxiaocu.monitor.basic.component;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @desc: 自定义健康端点
 * @author: hanchenghai
 * @date: 2018/11/06 4:40 PM
 */
@Component
public class CustomHealthIndicator // implements HealthIndicator{
	extends AbstractHealthIndicator {
	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {

		builder.withDetail("code","1234")
				.withDetail("version","v0.1")
				.up().build();

	}

	private static final String VERSION = "v1.0.0";

	// @Override
	// public Health health() {
	// 	int code = check();
	// 	if (code != 0){
	// 		Health.down().withDetail("code",code).withDetail("version",VERSION).build();
	// 	}
	// 	return Health.up().withDetail("code",code).withDetail("version",VERSION).up().build();
	// }
	//
	// private int check() {
	// 	return 0;
	// }
}
