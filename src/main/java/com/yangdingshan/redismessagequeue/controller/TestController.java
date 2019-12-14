package com.yangdingshan.redismessagequeue.controller;

import com.yangdingshan.redismessagequeue.message.MessageDTO;
import com.yangdingshan.redismessagequeue.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangdingshan
 * @Date: 2019/12/14 10:58
 * @Description:
 */
@RestController
@RequestMapping("/send")
public class TestController {

    @Autowired
    private Publisher publisher;

    @GetMapping("/message")
    public void send() {
        MessageDTO message = MessageDTO.builder().messageContent("messageContent").build();
        publisher.publish(message);
    }
}
