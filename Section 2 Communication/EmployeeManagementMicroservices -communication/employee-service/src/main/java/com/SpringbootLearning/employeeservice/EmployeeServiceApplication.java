package com.SpringbootLearning.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

/*	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}*/

/*	@Bean
	public WebClient webbClient(){
		return WebClient.builder().build();
	}*/

}
