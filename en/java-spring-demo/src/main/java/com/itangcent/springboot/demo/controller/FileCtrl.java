package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.dto.IResult;
import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.dto.UserDto;
import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * File Upload Controller
 * Handles user-related file upload operations, including single and multiple file uploads.
 * Supports both combined and separate submission of user information and files.
 *
 * @module user
 */
@RestController
@RequestMapping(value = "file")
public class FileCtrl {
    /**
     * Create new user and upload avatar
     * Uses @ModelAttribute to receive form data and file, implementing one-time submission of user information and avatar.
     * 
     * @param userDto Data transfer object containing user information and avatar file - UserDto contains basic user info and MultipartFile type avatar
     * @return Returns save result, returns "Save successful" message on success
     */
    @PostMapping("/add")
    public IResult add(@ModelAttribute UserDto userDto) {
        return Result.success("Save successful");
    }

    /**
     * Create new user and upload avatar (Separate parameter method)
     * User information and file are received separately, providing more flexible submission options
     *
     * @param userInfo Basic user information - Object containing username, age, and other basic information
     * @param profileImg User avatar file - Single avatar file, received using MultipartFile
     * @return Returns save result, returns "Save successful" message on success
     * @undone Interface to be improved - Need to add file size validation and type validation
     */
    @PostMapping("/add2")
    public IResult add(UserInfo userInfo,
                       @RequestParam(name = "profileImg") MultipartFile profileImg) {
        return Result.success("Save successful");
    }

    /**
     * Create new user and upload multiple avatars
     * Supports batch upload of avatar files, can upload multiple avatar images simultaneously
     *
     * @param userInfo Basic user information - Object containing username, age, and other basic information
     * @param profileImgs Multiple avatar files array - Supports uploading multiple avatar files simultaneously
     * @return Returns save result, returns "Save successful" message on success
     * @undone Interface to be improved - Need to add file quantity limit and total size limit
     */
    @PostMapping("/add3")
    public IResult add(UserInfo userInfo,
                       @RequestParam(name = "profileImg") MultipartFile[] profileImgs) {
        return Result.success("Save successful");
    }
}