package com.itangcent.common.model

import com.fasterxml.jackson.annotation.JsonIgnore

/**
 * JSON字段忽略测试Bean
 * 用于演示Jackson的@JsonIgnore注解功能
 * 在JSON序列化过程中忽略敏感字段
 */
data class TestJsonIgnoreBean(
    /**
     * 用户名
     * 正常进行JSON序列化
     */
    var userName: String? = null,

    /**
     * 密码
     * 使用@JsonIgnore注解，在JSON序列化时被忽略
     * 用于保护敏感信息
     */
    @JsonIgnore
    var password: String? = null
) 