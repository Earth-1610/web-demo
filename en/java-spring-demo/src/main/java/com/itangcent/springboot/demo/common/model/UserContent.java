package com.itangcent.springboot.demo.common.model;

/**
 * User Context Information Class
 * Contains basic user context information that can be automatically injected
 * Used for maintaining user context in request processing
 */
public class UserContent {

    /**
     * User ID
     * Unique identifier for the user in the system
     */
    private Long userId;

    /**
     * Username
     * Display name or login name of the user
     */
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
} 