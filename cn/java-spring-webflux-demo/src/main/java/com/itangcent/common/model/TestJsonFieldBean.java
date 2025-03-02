package com.itangcent.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JSON字段测试实体类
 * 用于演示JSON字段名称映射和自定义序列化的功能
 */
public class TestJsonFieldBean {

    /**
     * 字符串字段
     * 使用@JsonProperty注解自定义JSON字段名为"string_field"
     */
    @JsonProperty("string_field")
    private String stringField;

    /**
     * 整数字段
     * 使用@JsonProperty注解自定义JSON字段名为"int_field"
     */
    @JsonProperty("int_field")
    private Integer intField;

    /**
     * 布尔字段
     * 使用@JsonProperty注解自定义JSON字段名为"bool_field"
     */
    @JsonProperty("bool_field")
    private Boolean boolField;

    /**
     * 嵌套对象字段
     * 使用@JsonProperty注解自定义JSON字段名为"nested_field"
     * 演示复杂对象的序列化和反序列化
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
     * 嵌套测试实体类
     * 用于演示复杂对象的JSON序列化
     */
    public static class NestedBean {
        /**
         * 嵌套对象中的字符串字段
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