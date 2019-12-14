package com.yangdingshan.redismessagequeue;

import com.yangdingshan.redismessagequeue.consumer.RedisListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.integration.redis.util.RedisLockRegistry;

@SpringBootApplication
public class RedisMessageQueueApplication {

    @Autowired
    private RedisListener redisListener;

    public static void main(String[] args) {
        SpringApplication.run(RedisMessageQueueApplication.class, args);
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory factory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(redisListener, new PatternTopic("demo-channel"));
        return container;
    }

    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory factory) {
        return new RedisLockRegistry(factory, "demo-lock",60);
    }
}
