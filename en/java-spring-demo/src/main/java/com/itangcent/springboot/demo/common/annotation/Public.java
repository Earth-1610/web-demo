package com.itangcent.springboot.demo.common.annotation;

import java.lang.annotation.*;

/**
 * Public Interface Annotation
 * Used to mark API methods that can be publicly accessed
 * Can be accessed without authentication or special permissions
 */
@Target({ElementType.METHOD})  // Annotation can only be applied to methods
@Retention(RetentionPolicy.RUNTIME)  // Annotation is visible at runtime
@Documented  // Annotation will be included in JavaDoc
public @interface Public {
} 