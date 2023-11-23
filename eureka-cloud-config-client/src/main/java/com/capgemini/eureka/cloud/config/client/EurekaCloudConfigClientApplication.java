package com.capgemini.eureka.cloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDiscoveryClient
@ConfigurationProperties
public class EurekaCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaCloudConfigClientApplication.class, args);
	}

}
