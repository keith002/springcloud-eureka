package com.csdn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
 
    @Autowired
    private RabbitSendService rabbitService;
 
    @GetMapping(value = "/sendMsg")
    public String sendMsg() throws Exception {
        Message message = MessageBuilder.withPayload("Hello World".getBytes()).build();
        rabbitService.sendMsg().send(message);
        return "success";
    }
}
