package com.hanxiaocu.session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/24 10:26 AM
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {
}
