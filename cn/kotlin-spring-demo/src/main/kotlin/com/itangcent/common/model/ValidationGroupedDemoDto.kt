package com.itangcent.common.model

import com.itangcent.common.constant.Add
import com.itangcent.common.constant.Update
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * 分组验证演示DTO
 * 用于演示JSR-303分组验证功能
 * 针对不同操作场景使用不同的验证规则
 */
data class ValidationGroupedDemoDto(
    /**
     * ID字段
     * 仅在更新操作时必须非空
     * 添加操作时可以为空
     */
    @NotNull(groups = [Update::class])
    var id: Long? = null,

    /**
     * 名称字段
     * 在添加和更新操作时都不能为空
     * 同时应用于Add和Update分组
     */
    @NotBlank(groups = [Add::class, Update::class])
    var name: String? = null
)