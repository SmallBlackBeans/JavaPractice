package com.hanxiaocu.mongodb.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:19 PM
 */
@Configuration
public class MultipleMongoConfig {

	private final MultiMongoProperties mongoProperties;
	@Autowired
	public MultipleMongoConfig(MultiMongoProperties mongoProperties) {
		this.mongoProperties = mongoProperties;
	}

	@Primary
	@Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
	public MongoTemplate primaryMongoTemplate() throws Exception {
		return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
	}

	@Bean
	@Qualifier(SecondaryMongoConfig.MONGO_TEMPLATE)
	public MongoTemplate secondaryMongoTemplate() throws Exception {
		return new MongoTemplate(secondaryFactory(mongoProperties.getSecondary()));
	}


	@Bean
	@Primary
	public MongoDbFactory primaryFactory(MongoProperties properties) throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(properties.getHost(), properties.getPort()),properties.getDatabase());
	}


	@Bean
	public MongoDbFactory secondaryFactory(MongoProperties properties) throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(properties.getHost(),properties.getPort()),properties.getDatabase());
	}
}
