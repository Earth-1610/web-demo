package com.itangcent.springboot.kotlin.demo.swagger.dto

import io.swagger.annotations.ApiModelProperty

/**
 * Swagger模型类
 * 用于演示Swagger注解的使用方法
 */
class SwaggerModel {

    /**
     * 字段A
     * 已废弃的测试字段
     */
    @ApiModelProperty(value = "字段A", required = true)
    @Deprecated("不再使用")
    var a: String? = null

}