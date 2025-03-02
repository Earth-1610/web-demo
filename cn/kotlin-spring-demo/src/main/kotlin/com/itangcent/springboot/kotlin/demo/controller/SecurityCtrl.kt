package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.annotation.RolesAllowedInJava
import com.itangcent.common.model.TestJsonFieldBean
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.security.RolesAllowed

/**
 * 安全控制器
 * 用于演示Spring Security的角色权限控制功能
 */
@RestController
@RequestMapping("/test/security")
class SecurityCtrl {

    /**
     * 基于标准注解的角色权限控制
     * 演示使用@RolesAllowed注解进行权限控制
     *
     * @param testJsonFieldBean 测试数据对象
     * @return 返回原测试对象
     * @roles admin 需要管理员角色才能访问
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed")
    fun rolesAllowed(
            @RequestBody testJsonFieldBean: TestJsonFieldBean): TestJsonFieldBean {
        return testJsonFieldBean
    }

    /**
     * 基于自定义Java注解的角色权限控制
     * 演示使用自定义的@RolesAllowedInJava注解进行权限控制
     *
     * @param testJsonFieldBean 测试数据对象
     * @return 返回原测试对象
     * @roles admin 需要管理员角色才能访问
     */
    @RolesAllowedInJava(value = "admin", open = false)
    @RequestMapping("/rolesAllowed/java")
    fun rolesAllowedJava(
            @RequestBody testJsonFieldBean: TestJsonFieldBean): TestJsonFieldBean {
        return testJsonFieldBean
    }
}
