package com.hanxiaocu.mybits.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Description: MybaitsPlus 配置类
 * User: hanchenghai
 * Date: 2018/10/31 9:38 AM
 */
@Configuration
@ImportResource(locations = {"classpath:spring-mybaits.xml"})
public class MybatisPlusConfig {
}
