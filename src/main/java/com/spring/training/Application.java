package com.spring.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@ImportResource("classpath:spring-config.xml")
@EnableIntegration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
