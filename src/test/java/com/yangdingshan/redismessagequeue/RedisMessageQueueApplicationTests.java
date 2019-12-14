package com.yangdingshan.redismessagequeue;

import com.yangdingshan.redismessagequeue.message.MessageDTO;
import com.yangdingshan.redismessagequeue.publisher.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisMessageQueueApplicationTests {

    @Autowired
    private Publisher publisher;

    @Test
    void contextLoads() {
        MessageDTO message = MessageDTO.builder().messageContent("messageContent").build();
        publisher.publish(message);
    }

}
