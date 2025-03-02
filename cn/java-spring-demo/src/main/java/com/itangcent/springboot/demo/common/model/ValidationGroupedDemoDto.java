package com.itangcent.springboot.demo.common.model;

import com.itangcent.springboot.demo.common.constant.Add;
import com.itangcent.springboot.demo.common.constant.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 分组验证演示DTO
 * 用于展示JSR-303分组验证功能
 * 不同操作场景使用不同的验证规则
 */
public class ValidationGroupedDemoDto {
    /**
     * ID字段
     * 仅在更新操作时必须非null
     * 新增操作时可以为null
     */
    @NotNull(groups = Update.class)
    private Long id;

    /**
     * 名称字段
     * 在新增和更新操作时都不能为空
     * 同时适用于Add和Update分组
     */
    @NotBlank(groups = {Add.class, Update.class})
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