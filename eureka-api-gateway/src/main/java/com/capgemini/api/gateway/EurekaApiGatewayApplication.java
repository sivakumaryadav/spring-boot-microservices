package com.capgemini.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApiGatewayApplication.class, args);
	}

}
