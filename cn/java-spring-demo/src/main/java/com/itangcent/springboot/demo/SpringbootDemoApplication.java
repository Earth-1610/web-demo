package com.itangcent.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用程序的主入口类
 * 使用@SpringBootApplication注解标记这是一个Spring Boot应用
 */
@SpringBootApplication
public class SpringbootDemoApplication {

	/**
	 * 应用程序的主入口方法
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
