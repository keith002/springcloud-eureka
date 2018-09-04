package com.fymod.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(RabbitReceiveService.class)
@EnableEurekaClient
public class SpringcloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaClientApplication.class, args);
	}
	
}
