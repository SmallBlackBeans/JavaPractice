package com.hanxiaocu.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:18 PM
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.hanxiaocu.mongodb.repository.secondary",mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {

	protected static final String MONGO_TEMPLATE = "secondaryMongoTemplete";
}
