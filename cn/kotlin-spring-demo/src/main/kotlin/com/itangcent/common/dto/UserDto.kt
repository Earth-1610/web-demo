package com.itangcent.common.dto

import com.itangcent.common.model.UserInfo
import org.springframework.web.multipart.MultipartFile

/**
 * 用户数据传输对象
 * 继承自UserInfo，增加了文件上传功能
 * 用于处理包含文件上传的用户信息表单
 */
class UserDto : UserInfo() {
    /**
     * 用户头像文件
     * 用于上传用户的个人头像图片
     */
    var profileImg: MultipartFile? = null
}