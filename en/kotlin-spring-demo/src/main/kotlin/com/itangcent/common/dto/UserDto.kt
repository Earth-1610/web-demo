package com.itangcent.common.dto

import com.itangcent.common.model.UserInfo
import org.springframework.web.multipart.MultipartFile

/**
 * User Data Transfer Object
 * Extends UserInfo, adds file upload functionality
 * Used for handling user information forms that include file uploads
 */
class UserDto : UserInfo() {
    /**
     * User Profile Image File
     * Used for uploading user's personal profile picture
     */
    var profileImg: MultipartFile? = null
}