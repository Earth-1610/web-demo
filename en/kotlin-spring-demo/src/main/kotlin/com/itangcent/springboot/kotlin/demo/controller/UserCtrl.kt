package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation.*

/**
 * User Management Controller
 * Provides basic CRUD operation interfaces for user information
 *
 * @module user
 */
@RestController
@RequestMapping(value = ["user"])
class UserCtrl {

    /**
     * Welcome Interface
     * Returns a simple welcome message to test if the service is running normally
     *
     * @return Returns "hello world" string
     */
    @RequestMapping(value = ["/index"])
    fun greeting(): String {
        return "hello world"
    }

    /**
     * Update Username Interface (Deprecated)
     * Updates username and personal signature by specified user ID
     * Recommended to use the new update method instead
     *
     * @param id User ID, used to uniquely identify the user
     * @param newName New username
     * @param slogon Personal signature, default value is "haha"
     * @param times Operation count, default value is 10
     * @return Returns updated user information
     * @deprecated Please use [UserCtrl.update] method instead
     */
    @RequestMapping(method = [RequestMethod.PUT], value = ["/set"])
    @Deprecated("Use [UserCtrl.update] instead")
    fun set(id: Long,
            @RequestParam newName: String,
            @RequestParam(required = false, defaultValue = "haha") slogon: String,
            @RequestParam(required = false, defaultValue = "10") times: Long): Any {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = newName
        userInfo.age = 45
        return Result.success(userInfo)
    }

    /**
     * Get User Information Interface (Deprecated)
     * Gets detailed user information by user ID
     *
     * @param id User ID, used to uniquely identify the user
     * @return Returns response object containing detailed user information
     * @deprecated This interface is deprecated, please use the new interface instead
     */
    @Deprecated("")
    @GetMapping("/get/{id}")
    fun get(@PathVariable("id") id: Long?): IResult<UserInfo> {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = "Tony Stark"
        userInfo.age = 45
        return Result.success(userInfo)
    }

    /**
     * Add New User Interface
     * Creates a new user information record
     *
     * @param userInfo User information object containing detailed user information
     * @return Returns the successfully created user information
     */
    @PostMapping("/add")
    fun add(@RequestBody userInfo: UserInfo): Result<UserInfo> {
        return Result.success(userInfo)
    }

    /**
     * Update User Information Interface
     * Updates information for an existing user
     *
     * @param userInfo User information object containing information to be updated
     * @return Returns the updated user information
     */
    @PutMapping("update")
    fun update(@ModelAttribute userInfo: UserInfo): Result<UserInfo> {
        return Result.success(userInfo)
    }

    /**
     * Get User List Interface
     * Returns user list filtered by user type
     *
     * @param type User type, refer to [com.itangcent.common.constant.UserType]
     *             1: Administrator
     *             2: Regular Member
     *             3: Guest
     * @return Returns list of users matching the criteria
     */
    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(type: Int?): IResult<List<UserInfo>> {
        val userInfo = UserInfo()
        userInfo.id = 1L
        userInfo.name = "Tom"
        userInfo.age = 25
        return Result.success(listOf(userInfo))
    }

    /**
     * Get User List by Type Interface
     * Returns user list filtered by type specified in path parameter
     *
     * @param type User type, refer to [com.itangcent.common.constant.UserType]
     *             1: Administrator
     *             2: Regular Member
     *             3: Guest
     * @return Returns list of users of the specified type
     */
    @RequestMapping(value = ["/list/{type}"], method = [RequestMethod.GET])
    fun listTypeInPath(@PathVariable("type") type: Int?): IResult<List<UserInfo>> {
        val userInfo = UserInfo()
        userInfo.id = 1L
        userInfo.name = "Tom"
        userInfo.age = 25
        userInfo.type = type!!
        return Result.success(listOf(userInfo))
    }

    /**
     * Delete User Interface
     * Deletes user information by user ID
     *
     * @param id User ID to delete
     * @return Returns the deleted user information
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long?): Any {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = "Tony Stark"
        userInfo.age = 45
        return Result.success(userInfo)
    }
}
