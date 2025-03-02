package com.itangcent.springboot.demo.common.dto;

import com.itangcent.springboot.demo.common.constant.UserType;

/**
 * User Data Transfer Object with Enum Type
 * Uses UserType enum to represent user types
 * Used for standardized transmission and processing of user types
 */
public class UserDtoWithEnum {
    /**
     * User ID
     * Unique identifier within the system
     */
    private Long id;

    /**
     * User Name
     */
    private String name;

    /**
     * User Type
     * Uses UserType enum for type safety
     */
    private UserType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
} 