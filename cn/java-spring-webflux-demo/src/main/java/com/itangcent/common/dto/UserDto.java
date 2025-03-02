package com.itangcent.common.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * 用户数据传输对象
 * 用于在API接口中传输用户相关数据，支持文件上传
 */
public class UserDto {
    /**
     * 用户名
     * 用户登录账号或显示名称
     */
    private String username;

    /**
     * 密码
     * 用户的登录密码，应进行加密处理
     */
    private String password;

    /**
     * 年龄
     * 用户的实际年龄
     */
    private Integer age;

    /**
     * 头像文件
     * 用户上传的头像图片文件
     */
    private MultipartFile profileImg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MultipartFile getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(MultipartFile profileImg) {
        this.profileImg = profileImg;
    }
} 