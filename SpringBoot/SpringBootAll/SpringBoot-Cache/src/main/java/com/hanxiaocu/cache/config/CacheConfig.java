package com.hanxiaocu.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Description: 一二级缓存，追求性能
 * User: hanchenghai
 * Date: 2018/10/29 5:14 PM
 */
public class CacheConfig {
    //定义一个reids频道topic 默认叫cache
    @Value("${springext.cache.redis.topic:cache}")
    String topicName;

    @Bean
    public TwoLevelCacheManager cacheManager(StringRedisTemplate redisTemplate) {
        RedisCacheWriter  writer = RedisCacheWriter.lockingRedisCacheWriter(redisTemplate.getConnectionFactory());
        SerializationPair pair   = SerializationPair.fromSerializer(new JdkSerializationRedisSerializer(this.getClass().getClassLoader()));
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        TwoLevelCacheManager cacheManager = new TwoLevelCacheManager(redisTemplate,writer,config);
        return cacheManager;
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter,new PatternTopic(topicName));
        return container;
    }


    @Bean
    MessageListenerAdapter listenerAdapter(final TwoLevelCacheManager cacheManager) {
        return new MessageListenerAdapter(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] pattern) {
                byte[] bs = message.getChannel();
                try {
                    String type = new String(bs,"UTF-8");
                    String cacheName = new String(message.getBody(),"UTF-8");
                    cacheManager.receiver(cacheName);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    class TwoLevelCacheManager extends RedisCacheManager {

        private RedisTemplate redisTemplate;

        public TwoLevelCacheManager(RedisTemplate redisTemplate, RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
            super(cacheWriter, defaultCacheConfiguration);

            this.redisTemplate = redisTemplate;
        }

        //使用RedisAndLocalCache代替Spring Boot自带的RedisCache
        @Override
        protected Cache decorateCache(Cache cache) {
            return new RedisAndLocalCache((RedisCache) cache, this);
        }

        public void publishMessage(String cacheName) {
            this.redisTemplate.convertAndSend(topicName, cacheName);
        }

        public void receiver(String name) {
            RedisAndLocalCache cache = (RedisAndLocalCache) this.getCache(name);
            if (cache != null) {
                cache.clearLocal();
            }
        }
    }

    class RedisAndLocalCache implements Cache {
        ConcurrentMap<Object, Object> local = new ConcurrentHashMap<>();
        RedisCache                    redisCache;
        TwoLevelCacheManager          cacheManager;

        public RedisAndLocalCache(RedisCache redisCache, TwoLevelCacheManager cacheManager) {
            this.redisCache = redisCache;
            this.cacheManager = cacheManager;
        }

        @Override
        public String getName() {
            return redisCache.getName();
        }

        @Override
        public Object getNativeCache() {
            return redisCache.getNativeCache();
        }

        @Override
        public ValueWrapper get(Object o) {
            //一级缓存
            ValueWrapper wrapper = (ValueWrapper) local.get(o);
            if (wrapper != null) {
                return wrapper;
            } else {
                //二级缓存
                wrapper = redisCache.get(o);
                if (wrapper != null) {
                    local.put(o, wrapper);
                }
            }
            return wrapper;
        }

        @Override
        public <T> T get(Object o, Class<T> aClass) {
            return redisCache.get(o, aClass);
        }

        @Override
        public <T> T get(Object o, Callable<T> callable) {
            return redisCache.get(o, callable);
        }

        @Override
        public void put(Object key, Object value) {
            System.out.println(value.getClass().getClassLoader());
            redisCache.put(key, value);
            clearOtherJVM();
        }

        //如果不存在
        @Override
        public ValueWrapper putIfAbsent(Object key, Object value) {
            ValueWrapper wrapper = redisCache.putIfAbsent(key, value);
            clearOtherJVM();
            return wrapper;
        }

        @Override
        public void evict(Object o) {
            redisCache.evict(o);
            clearOtherJVM();
        }

        @Override
        public void clear() {
            redisCache.clear();
        }

        public void clearLocal() {
            this.local.clear();
        }

        //通知其他节点缓存更新
        protected void clearOtherJVM() {
            cacheManager.publishMessage(redisCache.getName());
        }

    }

}


