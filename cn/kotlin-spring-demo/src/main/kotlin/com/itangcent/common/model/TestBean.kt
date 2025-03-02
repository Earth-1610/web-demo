package com.itangcent.common.model

import com.fasterxml.jackson.annotation.JsonView

/**
 * 测试Bean类
 * 用于演示Jackson的@JsonView注解功能
 * 可以根据不同的视图显示不同的字段
 */
data class TestBean(
    /**
     * 在视图A中可见的字段
     * 仅在ViewA视图中序列化
     */
    @JsonView(ViewA::class)
    var aaAaa: String? = null,

    /**
     * 在视图B中可见的字段
     * 仅在ViewB视图中序列化
     */
    @JsonView(ViewB::class)
    var aaBbb: String? = null
) {
    /**
     * 视图A标记接口
     * 用于@JsonView注解标记在ViewA中可见的字段
     */
    interface ViewA

    /**
     * 视图B标记接口
     * 用于@JsonView注解标记在ViewB中可见的字段
     */
    interface ViewB
}