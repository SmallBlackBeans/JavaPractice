package com.hanxiaocu.monitor.config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 1:35 PM
 */
@Configuration
public class ActuatorConfig  {

@ConditionalOnMissingBean(HttpTraceRepository.class)
    @Bean
    public InMemoryHttpTraceRepository traceRepository() {
    InMemoryHttpTraceRepository traceRepository = new InMemoryHttpTraceRepository();
    //只缓存最近两条请求
    traceRepository.setCapacity(2);
    return traceRepository;
}
}
