package com.hanxiaocu.mongodb.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:11 PM
 */
@Data
@Component
@PropertySource(value = "classpath:mongodb.yml", encoding = "utf-8")
@ConfigurationProperties(prefix = "mongodb")
public class MultiMongoProperties {

	private MongoProperties primary = new MongoProperties();
	private MongoProperties secondary = new MongoProperties();

}
