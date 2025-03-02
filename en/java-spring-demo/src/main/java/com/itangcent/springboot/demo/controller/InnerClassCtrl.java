package com.itangcent.springboot.demo.controller;

import com.itangcent.springboot.demo.common.dto.Result;
import com.itangcent.springboot.demo.common.constant.UserType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Inner Class Test Controller
 * Demonstrates using static inner classes in controllers
 * Shows usage of inner classes as request/response objects
 *
 * @module user
 */
@RestController
@RequestMapping(value = "inner")
public class InnerClassCtrl extends BaseController {

    /**
     * Create new user
     * Uses inner class UserInfo as request and response object
     *
     * @param userInfo User information object
     * @return Returns the created user information
     */
    @PostMapping("/add")
    public Result<UserInfo> add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * User Information Inner Class
     * Contains user's basic information and validation rules
     */
    public static class UserInfo {

        /**
         * User ID
         * Unique identifier in the system
         */
        private Long id;

        /**
         * User Type
         * Refer to UserType enum values
         * @see UserType
         */
        private int type;

        /**
         * User Name
         * Cannot be empty string
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
         * @deprecated This field is no longer recommended for use
         */
        private Integer sex;

        /**
         * User Birthday
         * Format: yyyy-MM-dd
         */
        private LocalDate birthDay;

        /**
         * Registration Time
         * Timestamp of user's first registration
         */
        private LocalDateTime regtime;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
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
}
