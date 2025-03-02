package com.itangcent.springboot.demo.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON Field Name Mapping Test Bean
 * Used to demonstrate Jackson's @JsonProperty annotation functionality
 * Implements custom mapping between Java field names and JSON field names
 */
public class TestJsonFieldBean {
    /**
     * Username
     * Maps to "user-name" during JSON serialization
     */
    @JsonProperty("user-name")
    private String userName;

    /**
     * User Age
     * Maps to "user-age" during JSON serialization
     */
    @JsonProperty("user-age")
    private Integer userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
} 