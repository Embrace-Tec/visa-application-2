package com.visa.applicationregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRegistryApplication.class, args);
	}

}
