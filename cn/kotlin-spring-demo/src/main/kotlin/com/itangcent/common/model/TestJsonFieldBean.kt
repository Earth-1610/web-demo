package com.itangcent.common.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * JSON字段名映射测试Bean
 * 用于演示Jackson的@JsonProperty注解功能
 * 实现Java字段名和JSON字段名之间的自定义映射
 */
data class TestJsonFieldBean(
    /**
     * 用户名
     * 在JSON序列化中映射为"user-name"
     */
    @JsonProperty("user-name")
    var userName: String? = null,

    /**
     * 用户年龄
     * 在JSON序列化中映射为"user-age"
     */
    @JsonProperty("user-age")
    var userAge: Int? = null
) 