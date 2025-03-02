package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.model.TestJsonFieldBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * Spring Security权限控制测试
 * 演示不同的权限控制注解使用方式
 * 包括@RolesAllowed和@PreAuthorize注解
 *
 * @test a
 */
@RestController
@RequestMapping(value = "/test/security")
public class SecurityCtrl {

    /**
     * 自定义角色权限测试
     * 使用@RolesAllowed注解进行角色控制
     * 
     * @param testJsonFieldBean 测试用JSON字段Bean
     * @return 原样返回请求对象
     * @roleRequired admin 需要admin角色才能访问
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed/custom")
    public TestJsonFieldBean rolesAllowedCustom(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

    /**
     * Spring Security表达式权限测试
     * 使用@PreAuthorize注解进行权限控制
     * 
     * @param testJsonFieldBean 测试用JSON字段Bean
     * @return 原样返回请求对象
     * @roleRequired admin 需要admin角色才能访问
     */
    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/rolesAllowed/admin")
    public TestJsonFieldBean rolesAllowedAdmin(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

}
