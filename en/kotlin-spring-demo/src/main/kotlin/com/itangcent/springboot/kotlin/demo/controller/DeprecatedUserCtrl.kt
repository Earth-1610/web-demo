package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation.*

import java.util.Collections

/**
 * User Related (Deprecated)
 *
 * @module user
 */
@Deprecated("")
@RestController
@RequestMapping(value = ["/user/deprecated"])
class DeprecatedUserCtrl {

    /**
     * Say Hello
     */
    @Deprecated("")
    @RequestMapping(value = ["/index"])
    fun greeting(): String {
        return "hello world"
    }

    /**
     * Update Username
     *
     * @param id User ID
     * @param newName New username
     */
    @RequestMapping(value = ["/set"], method = [RequestMethod.PUT, RequestMethod.GET])
    @Deprecated("Use {@link #update(UserInfo)} instead")
    operator fun set(id: Long?, newName: String): Any {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = newName
        userInfo.age = 45
        return Result.success(userInfo)
    }

    /**
     * Get User Information
     *
     * @param id User ID
     */
    @GetMapping("/get/{id}")
    operator fun get(@PathVariable("id") id: Long?): IResult<UserInfo> {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = "Tony Stark"
        userInfo.age = 45
        return Result.success(userInfo)
    }

    /**
     * Add New User
     */
    @PostMapping("/add")
    fun add(@RequestBody userInfo: UserInfo): IResult<UserInfo> {
        return Result.success(userInfo)
    }

    /**
     * Update User Information
     */
    @PutMapping("update")
    fun update(@ModelAttribute userInfo: UserInfo): IResult<UserInfo> {
        return Result.success(userInfo)
    }

    /**
     * Get User List
     */
    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(): IResult<List<UserInfo>> {
        val userInfo = UserInfo()
        userInfo.id = 1L
        userInfo.name = "Tom"
        userInfo.age = 25
        return Result.success(listOf(userInfo))
    }

    /**
     * Delete User Information
     *
     * @param id User ID
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long?): IResult<UserInfo> {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = "Tony Stark"
        userInfo.age = 45
        return Result.success(userInfo)
    }

}
