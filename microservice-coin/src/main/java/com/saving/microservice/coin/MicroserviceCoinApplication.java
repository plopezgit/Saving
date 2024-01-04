package com.saving.microservice.coin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceCoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCoinApplication.class, args);
	}

}
