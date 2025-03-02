package com.itangcent.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * JSON字段忽略测试实体类
 * 演示如何在JSON序列化时忽略特定字段
 * 包含两种忽略方式：类级别注解和字段级别注解
 */
@JsonIgnoreProperties({"ignoredField1", "ignoredField2"})
public class TestJsonIgnoreBean {

    /**
     * 普通字段
     * 正常参与JSON序列化的字段
     */
    private String normalField;

    /**
     * 使用字段注解忽略的字段
     * 通过@JsonIgnore注解标记，在JSON序列化时会被忽略
     */
    @JsonIgnore
    private String ignoredByAnnotation;

    /**
     * 使用类注解忽略的字段1
     * 通过@JsonIgnoreProperties类注解配置忽略
     */
    private String ignoredField1;

    /**
     * 使用类注解忽略的字段2
     * 通过@JsonIgnoreProperties类注解配置忽略
     */
    private String ignoredField2;

    /**
     * 嵌套对象字段
     * 演示在复杂对象中使用字段忽略
     */
    private NestedIgnoreBean nestedBean;

    public String getNormalField() {
        return normalField;
    }

    public void setNormalField(String normalField) {
        this.normalField = normalField;
    }

    public String getIgnoredByAnnotation() {
        return ignoredByAnnotation;
    }

    public void setIgnoredByAnnotation(String ignoredByAnnotation) {
        this.ignoredByAnnotation = ignoredByAnnotation;
    }

    public String getIgnoredField1() {
        return ignoredField1;
    }

    public void setIgnoredField1(String ignoredField1) {
        this.ignoredField1 = ignoredField1;
    }

    public String getIgnoredField2() {
        return ignoredField2;
    }

    public void setIgnoredField2(String ignoredField2) {
        this.ignoredField2 = ignoredField2;
    }

    public NestedIgnoreBean getNestedBean() {
        return nestedBean;
    }

    public void setNestedBean(NestedIgnoreBean nestedBean) {
        this.nestedBean = nestedBean;
    }

    /**
     * 嵌套忽略测试实体类
     * 用于演示在嵌套对象中使用JSON字段忽略功能
     */
    public static class NestedIgnoreBean {
        /**
         * 嵌套对象中的普通字段
         */
        private String normalField;

        /**
         * 嵌套对象中被忽略的字段
         */
        @JsonIgnore
        private String ignoredField;

        public String getNormalField() {
            return normalField;
        }

        public void setNormalField(String normalField) {
            this.normalField = normalField;
        }

        public String getIgnoredField() {
            return ignoredField;
        }

        public void setIgnoredField(String ignoredField) {
            this.ignoredField = ignoredField;
        }
    }
} 