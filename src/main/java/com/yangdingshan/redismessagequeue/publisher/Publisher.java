package com.yangdingshan.redismessagequeue.publisher;

import com.yangdingshan.redismessagequeue.message.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: yangdingshan
 * @Date: 2019/12/14 10:46
 * @Description: 生产者bb
 */
@Service
public class Publisher {

    @Autowired
    private RedisTemplate redisTemplate;

    public void publish(MessageDTO msg){
        redisTemplate.convertAndSend("demo-channel",msg);
    }

}
