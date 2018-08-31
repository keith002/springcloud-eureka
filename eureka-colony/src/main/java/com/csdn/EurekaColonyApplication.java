package com.csdn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaColonyApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EurekaColonyApplication.class);
	}
	/**
	 * 打jar 进行使用
	 */
	public static void main(String[] args) {
//		SpringApplication.run(EurekaColonyApplication.class, args);
	    new SpringApplicationBuilder(EurekaColonyApplication.class).run(args);
	}
	/**
	 * 本地测试使用
	 */
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String profiles = scanner.nextLine();
//		new SpringApplicationBuilder(EurekaColonyApplication.class).profiles(profiles).run(args);
//	}

}