package com.hanxiaocu.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:15 PM
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.hanxiaocu.mongodb.repository.primary", mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {

	protected static final String MONGO_TEMPLATE = "primaryMongoTemplete";
}
