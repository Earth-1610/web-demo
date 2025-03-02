package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.annotation.RolesAllowedInJava
import com.itangcent.common.model.TestJsonFieldBean
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.security.RolesAllowed

/**
 * Security Controller
 * Used to demonstrate Spring Security's role-based access control functionality
 */
@RestController
@RequestMapping("/test/security")
class SecurityCtrl {

    /**
     * Role-based Access Control Using Standard Annotation
     * Demonstrates using @RolesAllowed annotation for permission control
     *
     * @param testJsonFieldBean Test data object
     * @return Returns the original test object
     * @roles admin Administrator role required for access
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed")
    fun rolesAllowed(
            @RequestBody testJsonFieldBean: TestJsonFieldBean): TestJsonFieldBean {
        return testJsonFieldBean
    }

    /**
     * Role-based Access Control Using Custom Java Annotation
     * Demonstrates using custom @RolesAllowedInJava annotation for permission control
     *
     * @param testJsonFieldBean Test data object
     * @return Returns the original test object
     * @roles admin Administrator role required for access
     */
    @RolesAllowedInJava(value = "admin", open = false)
    @RequestMapping("/rolesAllowed/java")
    fun rolesAllowedJava(
            @RequestBody testJsonFieldBean: TestJsonFieldBean): TestJsonFieldBean {
        return testJsonFieldBean
    }
}
