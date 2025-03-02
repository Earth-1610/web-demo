package com.itangcent.springboot.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.dto.UserDto
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * File Upload Controller
 * Provides file upload functionality for user-related operations, such as avatar uploads
 *
 * @module user
 */
@RestController
@RequestMapping(value = ["/file"])
class FileCtrl {
    /**
     * Add New User (Including Avatar Upload)
     * Uses ModelAttribute to receive user information and avatar file
     *
     * @param userDto Data transfer object containing user information and avatar file
     * @return Returns save result message
     */
    @PostMapping("/add")
    fun add(@ModelAttribute userDto: UserDto): IResult<String> {
        return Result.success("Save successful")
    }

    /**
     * Add New User (Separate Avatar Upload)
     * Demonstrates how to receive user information and avatar file separately
     *
     * @param userInfo Basic user information
     * @param profileImg User avatar file
     * @return Returns save result message
     * @undone To be implemented
     */
    @PostMapping("/add2")
    fun add(userInfo: UserInfo,
            @RequestParam(name = "profileImg") profileImg: MultipartFile): IResult<String> {
        return Result.success("Save successful")
    }

    /**
     * Add New User (Support Multiple Avatars)
     * Demonstrates how to handle multiple file upload scenarios
     *
     * @param userInfo Basic user information
     * @param profileImgs Array of multiple avatar files
     * @return Returns save result message
     * @undone To be implemented
     */
    @PostMapping("/add3")
    fun add(userInfo: UserInfo,
            @RequestParam(name = "profileImg") profileImgs: Array<MultipartFile>): IResult<String> {
        return Result.success("Save successful")
    }
}