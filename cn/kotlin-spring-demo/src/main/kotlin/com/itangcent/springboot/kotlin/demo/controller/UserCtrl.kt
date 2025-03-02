package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation.*

/**
 * 用户管理控制器
 * 提供用户信息的增删改查等基本操作接口
 *
 * @module user
 */
@RestController
@RequestMapping(value = ["user"])
class UserCtrl {

    /**
     * 欢迎接口
     * 返回简单的欢迎信息，用于测试服务是否正常运行
     *
     * @return 返回"hello world"字符串
     */
    @RequestMapping(value = ["/index"])
    fun greeting(): String {
        return "hello world"
    }

    /**
     * 更新用户名接口（已废弃）
     * 通过指定用户ID更新用户名和个人签名
     * 建议使用新的update方法替代
     *
     * @param id 用户ID，用于唯一标识用户
     * @param newName 新的用户名
     * @param slogon 个人签名，默认值为"haha"
     * @param times 操作次数，默认值为10
     * @return 返回更新后的用户信息
     * @deprecated 请使用 [UserCtrl.update] 方法替代
     */
    @RequestMapping(method = [RequestMethod.PUT], value = ["/set"])
    @Deprecated("改用 [UserCtrl.update]")
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
     * 获取用户信息接口（已废弃）
     * 根据用户ID获取用户的详细信息
     *
     * @param id 用户ID，用于唯一标识用户
     * @return 返回包含用户详细信息的响应对象
     * @deprecated 此接口已废弃，建议使用新的接口替代
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
     * 新增用户接口
     * 创建新的用户信息记录
     *
     * @param userInfo 用户信息对象，包含用户的详细信息
     * @return 返回创建成功的用户信息
     */
    @PostMapping("/add")
    fun add(@RequestBody userInfo: UserInfo): Result<UserInfo> {
        return Result.success(userInfo)
    }

    /**
     * 更新用户信息接口
     * 更新已存在用户的信息
     *
     * @param userInfo 用户信息对象，包含需要更新的用户信息
     * @return 返回更新后的用户信息
     */
    @PutMapping("update")
    fun update(@ModelAttribute userInfo: UserInfo): Result<UserInfo> {
        return Result.success(userInfo)
    }

    /**
     * 获取用户列表接口
     * 根据用户类型筛选并返回用户列表
     *
     * @param type 用户类型，参考 [com.itangcent.common.constant.UserType]
     *             1: 管理员
     *             2: 普通会员
     *             3: 访客
     * @return 返回符合条件的用户列表
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
     * 获取指定类型用户列表接口
     * 通过路径参数指定用户类型来获取用户列表
     *
     * @param type 用户类型，参考 [com.itangcent.common.constant.UserType]
     *             1: 管理员
     *             2: 普通会员
     *             3: 访客
     * @return 返回指定类型的用户列表
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
     * 删除用户接口
     * 根据用户ID删除指定用户信息
     *
     * @param id 要删除的用户ID
     * @return 返回被删除的用户信息
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
