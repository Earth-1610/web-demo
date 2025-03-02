package com.itangcent.common.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * User Data Transfer Object
 * Used for transferring user-related data in API interfaces, supports file upload
 */
public class UserDto {
    /**
     * Username
     * User login account or display name
     */
    private String username;

    /**
     * Password
     * User's login password, should be encrypted
     */
    private String password;

    /**
     * Age
     * User's actual age
     */
    private Integer age;

    /**
     * Profile Image
     * User's uploaded profile picture file
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