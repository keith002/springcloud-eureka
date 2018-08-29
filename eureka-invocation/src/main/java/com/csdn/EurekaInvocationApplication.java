package com.csdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaInvocationApplication {

   public static void main(String[] args) {
      SpringApplication.run(EurekaInvocationApplication.class, args);
   }
}