package com.itangcent.springboot.demo.common.model;

import com.itangcent.springboot.demo.common.constant.Add;
import com.itangcent.springboot.demo.common.constant.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Grouped Validation Demo DTO
 * Used to demonstrate JSR-303 group validation functionality
 * Different validation rules for different operation scenarios
 */
public class ValidationGroupedDemoDto {
    /**
     * ID field
     * Must be non-null only for update operations
     * Can be null for add operations
     */
    @NotNull(groups = Update.class)
    private Long id;

    /**
     * Name field
     * Cannot be empty for both add and update operations
     * Applies to both Add and Update groups
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