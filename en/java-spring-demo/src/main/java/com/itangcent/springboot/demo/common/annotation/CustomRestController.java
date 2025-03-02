package com.itangcent.springboot.demo.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * Custom REST Controller Annotation
 * This is a composite annotation that includes Spring's @RestController functionality
 * Can be used to mark RESTful API controller classes
 */
@Target({ElementType.TYPE})  // Annotation can only be applied to types (classes, interfaces, etc.)
@Retention(RetentionPolicy.RUNTIME)  // Annotation is visible at runtime
@Documented  // Annotation will be included in JavaDoc
@RestController  // Includes Spring's RestController functionality
public @interface CustomRestController {
} 