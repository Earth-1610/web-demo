package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.dto.UserDto
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * 文件上传控制器
 * 提供用户相关的文件上传功能，如头像上传等
 *
 * @module user
 */
@RestController
@RequestMapping(value = ["/file"])
class FileCtrl {
    /**
     * 新增用户（包含头像上传）
     * 使用ModelAttribute接收用户信息和头像文件
     *
     * @param userDto 包含用户信息和头像文件的数据传输对象
     * @return 返回保存结果信息
     */
    @PostMapping("/add")
    fun add(@ModelAttribute userDto: UserDto): IResult<String> {
        return Result.success("保存成功")
    }

    /**
     * 新增用户（头像单独上传）
     * 演示如何分别接收用户信息和头像文件
     *
     * @param userInfo 用户基本信息
     * @param profileImg 用户头像文件
     * @return 返回保存结果信息
     * @undone 待实现
     */
    @PostMapping("/add2")
    fun add(userInfo: UserInfo,
            @RequestParam(name = "profileImg") profileImg: MultipartFile): IResult<String> {
        return Result.success("保存成功")
    }

    /**
     * 新增用户（支持多个头像）
     * 演示如何处理多文件上传的场景
     *
     * @param userInfo 用户基本信息
     * @param profileImgs 多个头像文件数组
     * @return 返回保存结果信息
     * @undone 待实现
     */
    @PostMapping("/add3")
    fun add(userInfo: UserInfo,
            @RequestParam(name = "profileImg") profileImgs: Array<MultipartFile>): IResult<String> {
        return Result.success("保存成功")
    }
}