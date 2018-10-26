package com.hanxiaocu.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/26 9:30 AM
 */
@Configuration
public class EnvConfig {

    //@Value 支持 SpEL 表达式
    @Value("${cache.enable:false}")//如果不存在 呢么提供一个默认值
    private boolean isCache;

    @Autowired
    private Environment env;//应用最早初始化的类

    public int getServerPort() {
        return env.getProperty("server.port",Integer.class);
    }
}
