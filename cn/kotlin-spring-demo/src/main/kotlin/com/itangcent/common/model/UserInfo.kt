package com.itangcent.common.model

import java.time.LocalDate
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * 用户信息实体类
 * 包含用户的基本信息和注册信息
 */
open class UserInfo(
    /**
     * 用户ID
     * 系统中的唯一标识符
     */
    open var id: Long? = null,

    /**
     * 用户类型
     * 参考UserType枚举值
     */
    open var type: Int? = null,

    /**
     * 用户名称
     * 不能为空
     */
    @NotBlank
    open var name: String? = null,

    /**
     * 用户年龄
     * 不能为空
     */
    @NotNull
    open var age: Int? = null,

    /**
     * 用户性别
     * 0: 未知
     * 1: 男
     * 2: 女
     */
    open var sex: Int? = null,

    /**
     * 出生日期
     * 格式：yyyy-MM-dd
     */
    open var birthDay: LocalDate? = null,

    /**
     * 注册时间
     * 用户首次注册的时间戳
     */
    open var regtime: LocalDateTime? = null
) 