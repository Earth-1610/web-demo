package com.itangcent.springboot.demo.common.dto;

import com.itangcent.springboot.demo.common.model.UserInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * User Data Transfer Object
 * Extends UserInfo, adds file upload functionality
 * Used for handling user information forms that include file uploads
 */
public class UserDto extends UserInfo {
    /**
     * User Profile Image File
     * Used for uploading user's personal profile picture
     */
    private MultipartFile profileImg;

    public MultipartFile getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(MultipartFile profileImg) {
        this.profileImg = profileImg;
    }
} 