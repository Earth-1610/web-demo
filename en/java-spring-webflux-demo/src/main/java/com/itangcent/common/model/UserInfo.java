package com.itangcent.common.model;

/**
 * User Information Entity Class
 * Used for storing and transferring basic user information
 */
public class UserInfo {
    /**
     * User ID
     * Primary key that uniquely identifies a user in the system
     */
    private Long id;

    /**
     * User Name
     * Display name or nickname of the user
     */
    private String name;

    /**
     * User Age
     * Actual age of the user
     */
    private Integer age;

    /**
     * Profile Image URL
     * Access URL for the user's profile picture
     */
    private String profileImgUrl;

    /**
     * User Type
     * Indicates the role or level of the user
     * @see com.itangcent.common.constant.UserType
     */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
} 