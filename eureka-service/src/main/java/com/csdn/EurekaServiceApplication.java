package com.csdn;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaServiceApplication {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String port = scanner.nextLine();
      new SpringApplicationBuilder(EurekaServiceApplication.class)
            .properties("server.port=" + port).run(args);
   }

}