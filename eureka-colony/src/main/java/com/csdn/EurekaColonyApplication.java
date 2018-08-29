package com.csdn;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaColonyApplication {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String profiles = scanner.nextLine();
      new SpringApplicationBuilder(EurekaColonyApplication.class).profiles(profiles).run(args);
   }

}