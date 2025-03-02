package com.itangcent.springboot.demo.common.dto;

import com.itangcent.springboot.demo.common.constant.UserType;

/**
 * 带枚举类型的用户数据传输对象
 * 使用UserType枚举来表示用户类型
 * 用于规范化用户类型的传输和处理
 */
public class UserDtoWithEnum {
    /**
     * 用户ID
     * 系统内唯一标识
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户类型
     * 使用UserType枚举类型，提供类型安全
     */
    private UserType type;

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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
} 