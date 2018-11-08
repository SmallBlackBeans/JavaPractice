package com.hanxiaocu.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 11:12 AM
 */
@Configuration
public class RedisChannelListenerConfig {
    //对消息进行序列化工作，默认是StringRedisSerializer
    @Bean
    MessageListenerAdapter listenerAdapter() {
        MessageListenerAdapter adapter = new MessageListenerAdapter(new MyRedisChannelListener());
        //指定pub 消息序列化策略 转成json 存储
        //adapter.setSerializer(new GenericJackson2JsonRedisSerializer());
        return adapter;
    }

    //在接收到消息后，通过PatternTopic 派发到对应的消息监听者
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //订阅所有news.* 频道内容
        container.addMessageListener(listenerAdapter, new PatternTopic("news.*"));
        return container;
    }
}

class MyRedisChannelListener implements MessageListener {

    public void onMessage(Message message, byte[] bytes) {
        byte[] channal = message.getChannel();
        byte[] bs      = message.getBody();
        try {
            String connent = new String(bs, "UTF-8");
            String pub     = new String(channal, "UTF-8");
            System.out.println("get " + connent + " from " + pub);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
