package com.hanxiaocu.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 11:14 AM
 */
@Configuration
public class RedisConfig {

    //key 的序列化策略是 StringRedisSerializer
    @Bean("strKeyRedisTemplate")
    public RedisTemplate<Object,Object> strKeyRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer<String> stringSerizlizer = new StringRedisSerializer();
        template.setKeySerializer(stringSerizlizer);
        return template;
    }

    @Bean("jsonRedisTemplate")
    public RedisTemplate<Object,Object> jsonRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
