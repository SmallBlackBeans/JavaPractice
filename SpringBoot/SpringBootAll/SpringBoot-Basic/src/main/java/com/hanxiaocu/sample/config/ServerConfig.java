package com.hanxiaocu.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/26 9:36 AM
 */

@ConfigurationProperties("server")
@Configuration
public class ServerConfig {
    private int port;
    private String contextPath;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
