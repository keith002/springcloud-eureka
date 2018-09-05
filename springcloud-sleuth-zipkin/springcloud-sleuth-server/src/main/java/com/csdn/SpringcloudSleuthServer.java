package com.csdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class SpringcloudSleuthServer {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudSleuthServer.class, args);
	}
}
