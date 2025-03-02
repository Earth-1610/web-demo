package com.itangcent.common.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Data Validation Demo DTO
 * Used to demonstrate JSR-303 validation annotations
 * Contains basic non-null validation examples
 */
data class ValidationDemoDto(
    /**
     * ID Field
     * Cannot be null
     */
    @NotNull
    var id: Long? = null,

    /**
     * Name Field
     * Cannot be blank string or null
     */
    @NotBlank
    var name: String? = null
)