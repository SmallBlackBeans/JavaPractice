package com.hanxiaocu.sample.beetl;

import org.beetl.ext.simulate.WebSimulate;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 1:26 PM
 */
@Configuration
public class WebSimulateConfig {
    @Bean
    @ConditionalOnMissingBean //当从没有配置过WebSimulate 的时候 才调用这个方法
    public WebSimulate getWebSmulate(@Qualifier("beetlViewResolver") BeetlSpringViewResolver resolver) {
        WebSimulate webSimulate = new WebSimulate(resolver.getConfig().getGroupTemplate()) {

            @Override
            public String getValuePath(HttpServletRequest request) {
                return this.removePreffix(request.getServletPath());
            }

            @Override
            protected String getRenderPath(HttpServletRequest request) {
                return this.removePreffix(request.getServletPath());
            }

            private String removePreffix(String path) {
                return path.replaceFirst("/simulate/api", "");
            }
        };
        return webSimulate;
    }
}
