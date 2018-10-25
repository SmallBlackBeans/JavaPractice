package com.hanxiaocu.sample.beetl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.beetl.core.GroupTemplate;
import org.beetl.ext.simulate.JsonUtil;
import org.beetl.ext.simulate.WebSimulate;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 1:26 PM
 */
@Configuration
public class WebSimulateConfig {
    @Bean
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
