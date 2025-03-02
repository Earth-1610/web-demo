package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.model.TestJsonFieldBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * Spring Security Authorization Test
 * Demonstrates different authorization annotation usage
 * Including @RolesAllowed and @PreAuthorize annotations
 *
 * @test a
 */
@RestController
@RequestMapping(value = "/test/security")
public class SecurityCtrl {

    /**
     * Custom role authorization test
     * Uses @RolesAllowed annotation for role-based control
     * 
     * @param testJsonFieldBean Test JSON field bean
     * @return Returns the request object as is
     * @roleRequired admin Requires admin role to access
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed/custom")
    public TestJsonFieldBean rolesAllowedCustom(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

    /**
     * Spring Security expression authorization test
     * Uses @PreAuthorize annotation for authorization control
     * 
     * @param testJsonFieldBean Test JSON field bean
     * @return Returns the request object as is
     * @roleRequired admin Requires admin role to access
     */
    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/rolesAllowed/admin")
    public TestJsonFieldBean rolesAllowedAdmin(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

}
