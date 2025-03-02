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
 * 内部类测试控制器
 * 演示在控制器中使用静态内部类
 * 展示内部类作为请求/响应对象的用法
 *
 * @module user
 */
@RestController
@RequestMapping(value = "inner")
public class InnerClassCtrl extends BaseController {

    /**
     * 创建新用户
     * 使用内部类UserInfo作为请求和响应对象
     *
     * @param userInfo 用户信息对象
     * @return 返回创建的用户信息
     */
    @PostMapping("/add")
    public Result<UserInfo> add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * 用户信息内部类
     * 包含用户的基本信息和验证规则
     */
    public static class UserInfo {

        /**
         * 用户ID
         * 系统内唯一标识
         */
        private Long id;

        /**
         * 用户类型
         * 参考UserType枚举值定义
         * @see UserType
         */
        private int type;

        /**
         * 用户名称
         * 不能为空字符串
         */
        @NotBlank
        private String name;

        /**
         * 用户年龄
         * 不能为null
         */
        @NotNull
        private Integer age;

        /**
         * 用户性别
         * 0: 未知
         * 1: 男
         * 2: 女
         * @deprecated 该字段已不推荐使用
         */
        private Integer sex;

        /**
         * 用户生日
         * 格式：yyyy-MM-dd
         */
        private LocalDate birthDay;

        /**
         * 注册时间
         * 用户首次注册的时间戳
         */
        private LocalDateTime regtime;

        // Getter和Setter方法
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
