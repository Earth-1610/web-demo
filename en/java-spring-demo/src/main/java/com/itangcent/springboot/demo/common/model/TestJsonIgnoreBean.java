package com.itangcent.springboot.demo.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * JSON Field Ignore Test Bean
 * Used to demonstrate Jackson's @JsonIgnore annotation functionality
 * Ignores sensitive fields during JSON serialization
 */
public class TestJsonIgnoreBean {
    /**
     * Username
     * Normally participates in JSON serialization
     */
    private String userName;

    /**
     * Password
     * Uses @JsonIgnore annotation to exclude this field during JSON serialization
     * Used to protect sensitive information
     */
    @JsonIgnore
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} 