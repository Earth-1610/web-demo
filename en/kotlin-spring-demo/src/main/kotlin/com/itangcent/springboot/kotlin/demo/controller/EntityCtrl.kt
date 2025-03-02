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
 * Entity Response Controller
 * Used to demonstrate various Entity types usage in Spring Framework
 */
@RestController
@RequestMapping(value = ["/test/entity"])
class EntityCtrl {

    /**
     * Test ResponseEntity with Integer Type
     * Demonstrates how to return a simple integer type using ResponseEntity
     *
     * @param token Token from request header
     * @param requestEntity Request entity containing integer
     * @return Returns integer wrapped in ResponseEntity
     */
    @RequestMapping("/int")
    fun intInEntity(
            @RequestHeader("token") token: String,
            @RequestBody requestEntity: RequestEntity<Int>): ResponseEntity<Int> {
        return ResponseEntity.ok(65536)
    }

    /**
     * Test ResponseEntity with Complex Object
     * Demonstrates how to return a composite object containing Result using ResponseEntity
     *
     * @param token Token from request header
     * @param requestEntity Request entity containing user information
     * @return Returns Result<Double> wrapped in ResponseEntity
     */
    @RequestMapping("/double")
    fun doubleInEntity(
            @RequestHeader("token") token: String,
            @RequestBody requestEntity: RequestEntity<UserInfo>): ResponseEntity<IResult<Double>> {
        return ResponseEntity.ok(Result.success(65536.0))
    }

    /**
     * Test HttpEntity Response
     * Demonstrates how to return user information using HttpEntity
     *
     * @param token Token from request header
     * @return Returns user information wrapped in HttpEntity
     */
    @RequestMapping("/user")
    fun userInEntity(
            @RequestHeader("token") token: String): HttpEntity<IResult<UserInfo>> {
        val userInfo = UserInfo()
        userInfo.age = 18
        return ResponseEntity.ok(Result.success(userInfo))
    }
}
