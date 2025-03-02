package com.itangcent.common.dto

import com.itangcent.common.constant.UserType

/**
 * User DTO with Enum Type
 * Uses UserType enum to represent user type
 * For standardized user type transfer and processing
 */
data class UserDtoWithEnum(
    /**
     * User ID
     * Unique identifier in the system
     */
    var id: Long? = null,

    /**
     * User Name
     */
    var name: String? = null,

    /**
     * User Type
     * Uses UserType enum to ensure type safety
     */
    var type: UserType? = null
) 