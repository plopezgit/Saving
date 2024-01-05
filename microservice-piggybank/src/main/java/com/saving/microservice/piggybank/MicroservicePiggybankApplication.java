package com.saving.microservice.piggybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePiggybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePiggybankApplication.class, args);
	}

}