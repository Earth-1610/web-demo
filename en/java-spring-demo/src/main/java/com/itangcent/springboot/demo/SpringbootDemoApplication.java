package com.itangcent.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry class for the Spring Boot application
 * Marked with @SpringBootApplication annotation to indicate this is a Spring Boot application
 */
@SpringBootApplication
public class SpringbootDemoApplication {

	/**
	 * Main entry method for the application
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
