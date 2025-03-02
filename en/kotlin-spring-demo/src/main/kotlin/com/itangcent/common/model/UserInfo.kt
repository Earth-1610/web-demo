package com.itangcent.common.model

import java.time.LocalDate
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * User Information Entity Class
 * Contains basic user information and registration details
 */
open class UserInfo(
    /**
     * User ID
     * Unique identifier in the system
     */
    open var id: Long? = null,

    /**
     * User Type
     * Reference UserType enum values
     */
    open var type: Int? = null,

    /**
     * User Name
     * Cannot be blank
     */
    @NotBlank
    open var name: String? = null,

    /**
     * User Age
     * Cannot be null
     */
    @NotNull
    open var age: Int? = null,

    /**
     * User Gender
     * 0: Unknown
     * 1: Male
     * 2: Female
     */
    open var sex: Int? = null,

    /**
     * Birth Date
     * Format: yyyy-MM-dd
     */
    open var birthDay: LocalDate? = null,

    /**
     * Registration Time
     * Timestamp of user's first registration
     */
    open var regtime: LocalDateTime? = null
) 