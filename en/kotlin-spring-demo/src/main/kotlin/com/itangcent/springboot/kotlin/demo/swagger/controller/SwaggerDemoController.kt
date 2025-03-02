package com.itangcent.springboot.kotlin.demo.swagger.controller

import com.itangcent.springboot.kotlin.demo.swagger.dto.SwaggerModel
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Swagger Demo Controller
 * Used to demonstrate Swagger annotation usage and API documentation generation
 */
@RestController
@RequestMapping(value = ["swagger"])
@Api(value = "This is @Api swagger test SwaggerDemoController", tags = ["swagger test SwaggerDemoController"], produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
class SwaggerDemoController {

    /**
     * Welcome Interface
     * Returns a simple welcome message
     */
    @RequestMapping(value = ["/index"], method = [RequestMethod.GET], produces = [MediaType.TEXT_HTML_VALUE])
    @ApiOperation(value = "Greeting interface")
    fun greeting(): String {
        return "hello world"
    }

    /**
     * Get Swagger Model Example
     * Returns a SwaggerModel object for demonstration
     */
    @RequestMapping(value = ["/model"], method = [RequestMethod.GET], produces = [MediaType.TEXT_HTML_VALUE])
    @ApiOperation(value = "model")
    fun model(): SwaggerModel {
        return SwaggerModel()
    }

    /**
     * Set User Information Interface
     * Demonstrates complex Swagger annotation usage, including multiple parameter types and response descriptions
     */
    @ApiOperation(value = "Set interface", notes = "This is the set interface", tags = ["swagger", "test"])
    @RequestMapping(value = ["/set/{id}"], method = [RequestMethod.PUT], produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ApiResponse(code = 300, message = "This is the response", response = UserInfo::class)
    @ApiImplicitParams(value = [
        ApiImplicitParam(name = "implicitQuery", value = "An implicit parameter", defaultValue = "default name"),
        ApiImplicitParam(name = "implicitHeader", paramType = "header", value = "An implicit header parameter", defaultValue = "implicit_header"),
        ApiImplicitParam(name = "id", paramType = "path", value = "An implicit parameter", defaultValue = "implicit_path"),
        ApiImplicitParam(name = "implicitForm", paramType = "form", value = "An implicit form parameter", defaultValue = "implicit_form")
    ])
    @ApiResponses(
        ApiResponse(code = 200, message = "Normal return"),
        ApiResponse(code = 401, message = "Unauthorized"),
        ApiResponse(code = 403, message = "Still unauthorized")
    )
    @ApiImplicitParam(name = "implicit_query", value = "This is a hidden parameter", defaultValue = "implicit_query")
    operator fun set(
            @ApiParam(value = "This is the input id", name = "This is param's name", defaultValue = "1") id: Long,
            @ApiParam(value = "Input new name", defaultValue = "default name") @RequestParam newName: String?,
            @ApiParam(value = "Input hahaha", required = true, defaultValue = "default none") @RequestParam(required = false, defaultValue = "haha") slogon: String?,
            @ApiParam(value = "Input times", defaultValue = "20") @RequestParam(required = false, defaultValue = "11") times: Long): Any {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = newName
        userInfo.age = 45
        return Result.success(userInfo)
    }
}