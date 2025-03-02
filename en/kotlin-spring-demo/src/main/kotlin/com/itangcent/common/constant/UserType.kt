package com.itangcent.common.constant

/**
 * User Type Enumeration
 * Defines all possible user types in the system
 */
enum class UserType(val type: Int) {
    /**
     * Administrator User
     * Has the highest system privileges
     */
    ADMIN(1),

    /**
     * Regular Member User
     * Has basic system usage privileges
     */
    MEMBER(2),

    /**
     * Guest User
     * Has minimal system access privileges
     */
    GUEST(3)
} 