package com.itangcent.springboot.demo.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * JSON字段忽略测试Bean
 * 用于演示Jackson的@JsonIgnore注解功能
 * 在JSON序列化时忽略敏感字段
 */
public class TestJsonIgnoreBean {
    /**
     * 用户名
     * 正常参与JSON序列化
     */
    private String userName;

    /**
     * 密码
     * 使用@JsonIgnore注解，在JSON序列化时忽略此字段
     * 用于保护敏感信息
     */
    @JsonIgnore
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} 