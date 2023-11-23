package com.capgemini.eureka.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EurekaCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCloudConfigServerApplication.class, args);
	}

}
