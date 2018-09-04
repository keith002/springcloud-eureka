package com.csdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(RabbitSendService.class)
public class SpringcloudEurekaClientApplication01 {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaClientApplication01.class, args);
	}
}
