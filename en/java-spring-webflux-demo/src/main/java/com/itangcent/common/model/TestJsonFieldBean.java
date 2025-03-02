package com.itangcent.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON Field Test Entity Class
 * Used to demonstrate JSON field name mapping and custom serialization functionality
 */
public class TestJsonFieldBean {

    /**
     * String field
     * Uses @JsonProperty annotation to customize JSON field name as "string_field"
     */
    @JsonProperty("string_field")
    private String stringField;

    /**
     * Integer field
     * Uses @JsonProperty annotation to customize JSON field name as "int_field"
     */
    @JsonProperty("int_field")
    private Integer intField;

    /**
     * Boolean field
     * Uses @JsonProperty annotation to customize JSON field name as "bool_field"
     */
    @JsonProperty("bool_field")
    private Boolean boolField;

    /**
     * Nested object field
     * Uses @JsonProperty annotation to customize JSON field name as "nested_field"
     * Demonstrates serialization and deserialization of complex objects
     */
    @JsonProperty("nested_field")
    private NestedBean nestedField;

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public Integer getIntField() {
        return intField;
    }

    public void setIntField(Integer intField) {
        this.intField = intField;
    }

    public Boolean getBoolField() {
        return boolField;
    }

    public void setBoolField(Boolean boolField) {
        this.boolField = boolField;
    }

    public NestedBean getNestedField() {
        return nestedField;
    }

    public void setNestedField(NestedBean nestedField) {
        this.nestedField = nestedField;
    }

    /**
     * Nested Test Entity Class
     * Used to demonstrate JSON serialization of complex objects
     */
    public static class NestedBean {
        /**
         * String field in nested object
         */
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
} 