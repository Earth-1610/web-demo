package com.itangcent.common.model;

/**
 * 用户信息实体类
 * 用于存储和传输用户的基本信息
 */
public class UserInfo {
    /**
     * 用户ID
     * 系统中唯一标识用户的主键
     */
    private Long id;

    /**
     * 用户名称
     * 用户的显示名称或昵称
     */
    private String name;

    /**
     * 用户年龄
     * 用户的实际年龄
     */
    private Integer age;

    /**
     * 用户头像URL
     * 用户头像图片的访问地址
     */
    private String profileImgUrl;

    /**
     * 用户类型
     * 标识用户的角色或级别
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