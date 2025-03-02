package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import org.springframework.http.HttpEntity
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Entity响应控制器
 * 用于演示Spring框架中各种Entity类型的使用方法
 */
@RestController
@RequestMapping(value = ["/test/entity"])
class EntityCtrl {

    /**
     * 测试ResponseEntity包装整数类型
     * 演示如何使用ResponseEntity返回简单的整数类型
     *
     * @param token 请求头中的token
     * @param requestEntity 包含整数的请求实体
     * @return 返回包装在ResponseEntity中的整数
     */
    @RequestMapping("/int")
    fun intInEntity(
            @RequestHeader("token") token: String,
            @RequestBody requestEntity: RequestEntity<Int>): ResponseEntity<Int> {
        return ResponseEntity.ok(65536)
    }

    /**
     * 测试ResponseEntity包装复合对象
     * 演示如何使用ResponseEntity返回包含Result的复合对象
     *
     * @param token 请求头中的token
     * @param requestEntity 包含用户信息的请求实体
     * @return 返回包装在ResponseEntity中的Result<Double>对象
     */
    @RequestMapping("/double")
    fun doubleInEntity(
            @RequestHeader("token") token: String,
            @RequestBody requestEntity: RequestEntity<UserInfo>): ResponseEntity<IResult<Double>> {
        return ResponseEntity.ok(Result.success(65536.0))
    }

    /**
     * 测试HttpEntity响应
     * 演示如何使用HttpEntity返回用户信息
     *
     * @param token 请求头中的token
     * @return 返回包装在HttpEntity中的用户信息
     */
    @RequestMapping("/user")
    fun userInEntity(
            @RequestHeader("token") token: String): HttpEntity<IResult<UserInfo>> {
        val userInfo = UserInfo()
        userInfo.age = 18
        return ResponseEntity.ok(Result.success(userInfo))
    }
}
