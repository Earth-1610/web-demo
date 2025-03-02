package com.itangcent.springboot.demo.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON字段名称映射测试Bean
 * 用于演示Jackson的@JsonProperty注解功能
 * 实现Java字段名和JSON字段名的自定义映射
 */
public class TestJsonFieldBean {
    /**
     * 用户名
     * JSON序列化时映射为"user-name"
     */
    @JsonProperty("user-name")
    private String userName;

    /**
     * 用户年龄
     * JSON序列化时映射为"user-age"
     */
    @JsonProperty("user-age")
    private Integer userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
} 