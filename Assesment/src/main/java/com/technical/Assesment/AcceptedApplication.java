package com.technical.Assesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AcceptedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcceptedApplication.class, args);
	}

}
