package com.hanxiaocu.sample.cache;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Description: 对存入数据库的手机加密
 * User: hanchenghai
 * Date: 2018/10/26 10:21 AM
 */

@Configuration
public class MobileEncrpyCondition {


    @Bean
    @Conditional(EncryptCondition.class)
    public MobileEncrpyBean mobileEncrpyBean() {
        return new MobileEncrpyBean();
    }

    static class EncryptCondition implements Condition {
        @Override
        public boolean matches(ConditionContext ctx, AnnotatedTypeMetadata annotatedTypeMetadata) {
            Resource res = ctx.getResourceLoader().getResource("salt.txt");
            Environment env = ctx.getEnvironment();
            return res.exists() && env.containsProperty("mobile.encrypt.enable");
        }
    }

    static class MobileEncrpyBean {
    }
}
