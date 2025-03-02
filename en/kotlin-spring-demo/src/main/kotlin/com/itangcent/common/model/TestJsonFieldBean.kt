package com.itangcent.common.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * JSON Field Name Mapping Test Bean
 * Used to demonstrate Jackson's @JsonProperty annotation functionality
 * Implements custom mapping between Java field names and JSON field names
 */
data class TestJsonFieldBean(
    /**
     * Username
     * Mapped to "user-name" in JSON serialization
     */
    @JsonProperty("user-name")
    var userName: String? = null,

    /**
     * User Age
     * Mapped to "user-age" in JSON serialization
     */
    @JsonProperty("user-age")
    var userAge: Int? = null
) 