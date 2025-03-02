package com.itangcent.springboot.demo.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A swagger model example")
public class SwaggerModel {
    
    @ApiModelProperty(value = "Model ID", required = true, example = "1")
    private Long id = 1L;
    
    @ApiModelProperty(value = "Model name", required = true, example = "demo")
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