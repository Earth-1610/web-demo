package com.itangcent.common.model

import com.itangcent.common.constant.Add
import com.itangcent.common.constant.Update
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Grouped Validation Demo DTO
 * Used to demonstrate JSR-303 group validation functionality
 * Uses different validation rules for different operation scenarios
 */
data class ValidationGroupedDemoDto(
    /**
     * ID Field
     * Must not be null only for update operations
     * Can be null for add operations
     */
    @NotNull(groups = [Update::class])
    var id: Long? = null,

    /**
     * Name Field
     * Cannot be blank for both add and update operations
     * Applied to both Add and Update groups
     */
    @NotBlank(groups = [Add::class, Update::class])
    var name: String? = null
)