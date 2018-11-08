package com.hanxiaocu.sample.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.system.JavaVersion;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/26 9:52 AM
 */
//matchIfMissing 如果环境中没有包含对应的属性，配置也能生效
@ConditionalOnProperty(name = "message.center.enabled",havingValue = "true",matchIfMissing = true)
@ConditionalOnJava(range = ConditionalOnJava.Range.EQUAL_OR_NEWER,value = JavaVersion.EIGHT)
public class MessageCenterAutoConfig {
}
