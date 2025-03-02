package com.itangcent.common.model

/**
 * 测试日志Bean类
 * 用于演示@Transient注解的使用
 * 包含敏感信息处理示例
 */
data class TestLogBean(
    /**
     * 用户名
     * 正常序列化和持久化
     */
    var userName: String? = null,

    /**
     * 密码
     * 使用@Transient标记，不包含在序列化中
     * 用于保护敏感信息
     */
    @Transient
    var password: String? = null
) 