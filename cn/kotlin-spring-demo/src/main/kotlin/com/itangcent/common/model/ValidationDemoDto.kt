package com.itangcent.common.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * 数据验证演示DTO
 * 用于演示JSR-303验证注解
 * 包含基本的非空验证示例
 */
data class ValidationDemoDto(
    /**
     * ID字段
     * 不能为空
     */
    @NotNull
    var id: Long? = null,

    /**
     * 名称字段
     * 不能为空字符串或null
     */
    @NotBlank
    var name: String? = null
)