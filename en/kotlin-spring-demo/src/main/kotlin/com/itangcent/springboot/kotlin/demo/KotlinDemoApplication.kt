package com.itangcent.springboot.kotlin.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Kotlin Spring Boot Demo Application
 * This is the main entry class for the application
 */
@SpringBootApplication
class KotlinDemoApplication

/**
 * Application Entry Point
 * Starts the Spring Boot application
 */
fun main(args: Array<String>) {
	runApplication<KotlinDemoApplication>(*args)
}
