package com.csdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient // 之适用于Eureka
// @EnableDiscoveryClient // 支持多种注册中心
@EnableFeignClients
@EnableCircuitBreaker
@ServletComponentScan // 注解来扫描拦截器
public class EurekaInvocationApplication {

   public static void main(String[] args) {
      SpringApplication.run(EurekaInvocationApplication.class, args);
   }
}