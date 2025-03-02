package com.itangcent.springboot.demo.common.constant;

/**
 * User Type Enumeration
 * Defines the different types of users in the system
 * Used for role-based access control and user management
 */
public enum UserType {
    /**
     * Administrator user type
     * Has full system access and management privileges
     */
    ADMIN(1),

    /**
     * Regular member user type
     * Has standard user privileges
     */
    MEMBER(2),

    /**
     * Guest user type
     * Has limited access to public features only
     */
    GUEST(3);

    /**
     * The numeric value associated with the user type
     */
    private final int type;

    /**
     * Constructor for UserType enum
     * @param type The numeric value for the user type
     */
    UserType(int type) {
        this.type = type;
    }

    /**
     * Get the numeric value of the user type
     * @return The numeric value representing the user type
     */
    public int getType() {
        return type;
    }
} 