package com.fymod.eureka.client;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitReceiveService {
	@Input(value = "myInput")
	SubscribableChannel inputMsg() throws Exception;
}
