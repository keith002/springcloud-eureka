package com.fymod.eureka.client;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiveListener {
    @StreamListener(value = "myInput")
    public void onReceive(byte[] msg){
        System.out.println(new String(msg));
    }
}
