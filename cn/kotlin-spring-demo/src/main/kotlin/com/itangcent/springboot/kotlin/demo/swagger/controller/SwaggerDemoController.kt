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
 * Swagger示例控制器
 * 用于演示Swagger注解的使用方法和API文档生成
 */
@RestController
@RequestMapping(value = ["swagger"])
@Api(value = "这是@Api swagger测试 SwaggerDemoController", tags = ["swagger测试 SwaggerDemoController"], produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
class SwaggerDemoController {

    /**
     * 欢迎接口
     * 返回简单的欢迎信息
     */
    @RequestMapping(value = ["/index"], method = [RequestMethod.GET], produces = [MediaType.TEXT_HTML_VALUE])
    @ApiOperation(value = "打个招呼接口")
    fun greeting(): String {
        return "hello world"
    }

    /**
     * 获取Swagger模型示例
     * 返回一个SwaggerModel对象用于演示
     */
    @RequestMapping(value = ["/model"], method = [RequestMethod.GET], produces = [MediaType.TEXT_HTML_VALUE])
    @ApiOperation(value = "model")
    fun model(): SwaggerModel {
        return SwaggerModel()
    }

    /**
     * 设置用户信息接口
     * 演示复杂的Swagger注解使用，包括多种参数类型和响应说明
     */
    @ApiOperation(value = "设置接口", notes = "这是设置接口", tags = ["swagger", "test"])
    @RequestMapping(value = ["/set/{id}"], method = [RequestMethod.PUT], produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ApiResponse(code = 300, message = "这是响应", response = UserInfo::class)
    @ApiImplicitParams(value = [
        ApiImplicitParam(name = "implicitQuery", value = "一个隐式的参数", defaultValue = "默认名字"),
        ApiImplicitParam(name = "implicitHeader", paramType = "header", value = "一个隐式的Header参数", defaultValue = "implicit_header"),
        ApiImplicitParam(name = "id", paramType = "path", value = "一个隐式的参数", defaultValue = "implicit_path"),
        ApiImplicitParam(name = "implicitForm", paramType = "form", value = "一个隐式的form参数", defaultValue = "implicit_form")
    ])
    @ApiResponses(
        ApiResponse(code = 200, message = "正常返回"),
        ApiResponse(code = 401, message = "无权限"),
        ApiResponse(code = 403, message = "还是无权限")
    )
    @ApiImplicitParam(name = "implicit_query", value = "这是隐藏的参数", defaultValue = "implicit_query")
    operator fun set(
            @ApiParam(value = "这是入参id", name = "这是param's name", defaultValue = "1") id: Long,
            @ApiParam(value = "入参新名字", defaultValue = "默认名字") @RequestParam newName: String?,
            @ApiParam(value = "入参哈哈哈", required = true, defaultValue = "默认无") @RequestParam(required = false, defaultValue = "haha") slogon: String?,
            @ApiParam(value = "入参times", defaultValue = "20") @RequestParam(required = false, defaultValue = "11") times: Long): Any {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = newName
        userInfo.age = 45
        return Result.success(userInfo)
    }
}