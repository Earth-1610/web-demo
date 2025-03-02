package com.itangcent.springboot.kotlin.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Kotlin Spring Boot 示例应用程序
 * 这是应用程序的主入口类
 */
@SpringBootApplication
class KotlinDemoApplication

/**
 * 应用程序入口点
 * 启动 Spring Boot 应用程序
 */
fun main(args: Array<String>) {
	runApplication<KotlinDemoApplication>(*args)
}
