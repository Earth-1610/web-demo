package com.itangcent.springboot.demo.common.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * User Information Entity Class
 * Contains user's basic information and registration details
 */
public class UserInfo {
    /**
     * User ID
     * Unique identifier in the system
     */
    private Long id;

    /**
     * User Type
     * Refer to UserType enum values
     */
    private Integer type;

    /**
     * User Name
     * Cannot be empty
     */
    @NotBlank
    private String name;

    /**
     * User Age
     * Cannot be null
     */
    @NotNull
    private Integer age;

    /**
     * User Gender
     * 0: Unknown
     * 1: Male
     * 2: Female
     */
    private Integer sex;

    /**
     * Birth Date
     * Format: yyyy-MM-dd
     */
    private LocalDate birthDay;

    /**
     * Registration Time
     * Timestamp of user's first registration
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