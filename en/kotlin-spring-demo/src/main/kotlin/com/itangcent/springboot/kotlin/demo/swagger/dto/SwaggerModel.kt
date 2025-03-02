package com.itangcent.springboot.kotlin.demo.swagger.dto

import io.swagger.annotations.ApiModelProperty

/**
 * Swagger Model Class
 * Used to demonstrate Swagger annotation usage
 */
class SwaggerModel {

    /**
     * Field A
     * Deprecated test field
     */
    @ApiModelProperty(value = "Field A", required = true)
    @Deprecated("No longer in use")
    var a: String? = null

}