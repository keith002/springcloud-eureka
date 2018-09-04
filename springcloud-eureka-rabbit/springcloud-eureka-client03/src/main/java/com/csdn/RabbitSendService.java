package com.csdn;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitSendService {

	@Output(value = "myInput")
    SubscribableChannel sendMsg() throws Exception;
}
