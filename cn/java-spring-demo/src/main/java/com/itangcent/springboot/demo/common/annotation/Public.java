package com.itangcent.springboot.demo.common.annotation;

import java.lang.annotation.*;

/**
 * 公开接口注解
 * 用于标记可以公开访问的API方法
 * 不需要认证或特殊权限即可访问
 */
@Target({ElementType.METHOD})  // 注解只能应用于方法
@Retention(RetentionPolicy.RUNTIME)  // 注解在运行时可见
@Documented  // 注解将被包含在JavaDoc中
public @interface Public {
} 