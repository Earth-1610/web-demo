package com.itangcent.springboot.demo.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * 自定义REST控制器注解
 * 这是一个组合注解，包含了Spring的@RestController功能
 * 可以用于标记RESTful API的控制器类
 */
@Target({ElementType.TYPE})  // 注解只能应用于类型（类、接口等）
@Retention(RetentionPolicy.RUNTIME)  // 注解在运行时可见
@Documented  // 注解将被包含在JavaDoc中
@RestController  // 包含Spring的RestController功能
public @interface CustomRestController {
} 