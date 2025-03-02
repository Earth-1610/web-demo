package com.itangcent.springboot.demo.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "一个swagger模型示例")
public class SwaggerModel {
    
    @ApiModelProperty(value = "模型id", required = true, example = "1")
    private Long id = 1L;
    
    @ApiModelProperty(value = "模型名称", required = true, example = "demo")
    private String name = "demo";
    
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