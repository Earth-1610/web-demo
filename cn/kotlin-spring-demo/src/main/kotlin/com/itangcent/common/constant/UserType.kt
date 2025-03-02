package com.itangcent.common.constant

/**
 * 用户类型枚举
 * 定义系统中所有可能的用户类型
 */
enum class UserType(val type: Int) {
    /**
     * 管理员用户
     * 具有系统最高权限
     */
    ADMIN(1),

    /**
     * 普通会员用户
     * 具有基本的系统使用权限
     */
    MEMBER(2),

    /**
     * 访客用户
     * 具有最低限度的系统访问权限
     */
    GUEST(3)
} 