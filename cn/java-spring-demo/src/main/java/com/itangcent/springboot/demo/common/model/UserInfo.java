package com.itangcent.springboot.demo.common.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户信息实体类
 * 包含用户的基本信息和注册信息
 */
public class UserInfo {
    /**
     * 用户ID
     * 系统内唯一标识
     */
    private Long id;

    /**
     * 用户类型
     * 参考 UserType 枚举值
     */
    private Integer type;

    /**
     * 用户姓名
     * 不能为空
     */
    @NotBlank
    private String name;

    /**
     * 用户年龄
     * 不能为空
     */
    @NotNull
    private Integer age;

    /**
     * 用户性别
     * 0: 未知
     * 1: 男
     * 2: 女
     */
    private Integer sex;

    /**
     * 出生日期
     * 格式：yyyy-MM-dd
     */
    private LocalDate birthDay;

    /**
     * 注册时间
     * 用户首次注册的时间戳
     */
    private LocalDateTime regtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDateTime getRegtime() {
        return regtime;
    }

    public void setRegtime(LocalDateTime regtime) {
        this.regtime = regtime;
    }
} 