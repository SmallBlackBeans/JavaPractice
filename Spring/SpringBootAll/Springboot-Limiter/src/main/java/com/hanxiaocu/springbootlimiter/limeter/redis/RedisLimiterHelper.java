package com.hanxiaocu.springbootlimiter.limeter.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/21 2:58 PM
 */
@Configuration
public class RedisLimiterHelper {

	@Bean
	public RedisTemplate<String, Serializable> limitRedisTemplate(LettuceConnectionFactory redisConnetionFactory){
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setConnectionFactory(redisConnetionFactory);
		return template;
	}
}
