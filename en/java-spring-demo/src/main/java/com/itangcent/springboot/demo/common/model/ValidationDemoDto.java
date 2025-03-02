package com.itangcent.springboot.demo.common.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Validation Demo DTO
 * Used to demonstrate the usage of JSR-303 validation annotations
 * Contains basic non-null validation examples
 */
public class ValidationDemoDto {
    /**
     * ID field
     * Cannot be null
     */
    @NotNull
    private Long id;

    /**
     * Name field
     * Cannot be empty string or null
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