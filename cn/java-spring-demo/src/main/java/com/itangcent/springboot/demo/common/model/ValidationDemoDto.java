package com.itangcent.springboot.demo.common.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 数据验证演示DTO
 * 用于展示JSR-303验证注解的使用
 * 包含基本的非空验证示例
 */
public class ValidationDemoDto {
    /**
     * ID字段
     * 不能为null
     */
    @NotNull
    private Long id;

    /**
     * 名称字段
     * 不能为空字符串或null
     */
    @NotBlank
    private String name;

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
} 