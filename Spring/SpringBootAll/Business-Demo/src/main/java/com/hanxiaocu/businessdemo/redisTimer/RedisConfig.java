package com.hanxiaocu.businessdemo.redisTimer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/22 10:03 AM
 */
@Configuration
public class RedisConfig {

	@Bean("orderRedisTemplate")
	public RedisTemplate<String,Object> strKeyRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		RedisSerializer<String> stringSerizlizer = new StringRedisSerializer();
		template.setKeySerializer(stringSerizlizer);
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		return template;
	}

}
