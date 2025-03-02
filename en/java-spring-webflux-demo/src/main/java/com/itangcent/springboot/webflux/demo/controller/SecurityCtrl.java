package com.itangcent.springboot.webflux.demo.controller;


import com.itangcent.common.model.TestJsonFieldBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.security.RolesAllowed;


/**
 * Security Controller
 * Used to demonstrate role-based access control functionality
 */
@RestController
@RequestMapping(value = "/test/security")
public class SecurityCtrl {

    /**
     * Test Role-based Access Control
     * Demonstrates using @RolesAllowed annotation for access control
     * Only users with admin role can access this interface
     *
     * @param testJsonFieldBean Test data object
     * @return Processing result
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed")
    public Mono<TestJsonFieldBean> rolesAllowed(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return Mono.just(testJsonFieldBean);
    }

}
