package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.dto.UserDto;
import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传控制器
 * 处理用户相关的文件上传操作，包括单文件和多文件上传功能。
 * 支持用户信息和文件的同时提交，以及分离提交两种方式。
 *
 * @module user
 */
@RestController
@RequestMapping(value = "file")
public class FileCtrl {
    /**
     * 创建新用户并上传头像
     * 使用@ModelAttribute接收表单数据和文件，实现用户信息和头像的一次性提交。
     * 
     * @param userDto 包含用户信息和头像文件的数据传输对象 - UserDto中包含用户基本信息和MultipartFile类型的头像文件
     * @return 返回保存结果，成功时返回"保存成功"消息
     */
    @PostMapping("/add")
    public IResult add(@ModelAttribute UserDto userDto) {
        return Result.success("保存成功");
    }

    /**
     * 创建新用户并上传头像（分离参数方式）
     * 用户信息和文件分开接收，提供更灵活的提交方式
     *
     * @param userInfo 用户基本信息 - 包含用户名、年龄等基本信息的对象
     * @param profileImg 用户头像文件 - 单个头像文件，使用MultipartFile接收
     * @return 返回保存结果，成功时返回"保存成功"消息
     * @undone 待完善的接口 - 需要添加文件大小验证和类型验证
     */
    @PostMapping("/add2")
    public IResult add(UserInfo userInfo,
                       @RequestParam(name = "profileImg") MultipartFile profileImg) {
        return Result.success("保存成功");
    }

    /**
     * 创建新用户并上传多个头像
     * 支持批量上传头像文件，可以同时上传多张头像图片
     *
     * @param userInfo 用户基本信息 - 包含用户名、年龄等基本信息的对象
     * @param profileImgs 多个头像文件数组 - 支持同时上传多个头像文件
     * @return 返回保存结果，成功时返回"保存成功"消息
     * @undone 待完善的接口 - 需要添加文件数量限制和总大小限制
     */
    @PostMapping("/add3")
    public IResult add(UserInfo userInfo,
                       @RequestParam(name = "profileImg") MultipartFile[] profileImgs) {
        return Result.success("保存成功");
    }
}