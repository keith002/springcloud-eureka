package com.fymod.eureka.server;

import org.springframework.messaging.SubscribableChannel;

public interface RabbitSendService {

//	@Output(value = "myInput")
    SubscribableChannel sendMsg() throws Exception;
}
