package com.csdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // Hystrix 仪表板；
						// hystrix 查看仪表盘；在hystrix客户端应用使用
						// hystrix.stream监控
public class EurekaHystrixMonitorApplication {

   public static void main(String[] args) {
      SpringApplication.run(EurekaHystrixMonitorApplication.class, args);
   }
}
