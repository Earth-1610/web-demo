package com.itangcent.common.model

import com.fasterxml.jackson.annotation.JsonIgnore

/**
 * JSON Field Ignore Test Bean
 * Used to demonstrate Jackson's @JsonIgnore annotation functionality
 * Ignores sensitive fields during JSON serialization
 */
data class TestJsonIgnoreBean(
    /**
     * Username
     * Normal JSON serialization
     */
    var userName: String? = null,

    /**
     * Password
     * Using @JsonIgnore annotation, ignored during JSON serialization
     * Used to protect sensitive information
     */
    @JsonIgnore
    var password: String? = null
) 