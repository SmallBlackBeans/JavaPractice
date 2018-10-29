package com.hanxiaocu.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 10:43 AM
 */
@Controller
@RequestMapping("/strredis")
public class RedisStringController {

    @Autowired
    StringRedisTemplate redisClient;

    @RequestMapping("/setget.html")
    public @ResponseBody
    String env(String param) {
        redisClient.opsForValue().set("testenv", param);
        String str = redisClient.opsForValue().get("testenv");
        return str;
    }

    //绑定key 然后使用operations，不用每次都指定key了
    @RequestMapping("/bindkey.html")
    public @ResponseBody
    String bindKey(String key) {
        BoundListOperations operations = redisClient.boundListOps(key);
        operations.leftPush("a");
        operations.leftPush("b");
        return String.valueOf(operations.size());
    }

    @RequestMapping("/connectionset.html")
    public @ResponseBody
    String connectionSet(final String key, final String value) throws Exception {
        redisClient.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection conn) throws DataAccessException {
                conn.set(key.getBytes(), value.getBytes());
                return null;
            }
        });
        return "success";
    }
}
