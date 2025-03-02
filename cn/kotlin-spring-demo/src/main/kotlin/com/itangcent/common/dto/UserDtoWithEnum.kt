package com.itangcent.common.dto

import com.itangcent.common.constant.UserType

/**
 * 带枚举类型的用户DTO
 * 使用UserType枚举表示用户类型
 * 用于标准化用户类型的传输和处理
 */
data class UserDtoWithEnum(
    /**
     * 用户ID
     * 系统中的唯一标识符
     */
    var id: Long? = null,

    /**
     * 用户名称
     */
    var name: String? = null,

    /**
     * 用户类型
     * 使用UserType枚举类型以保证类型安全
     */
    var type: UserType? = null
) 