package com.itangcent.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * JSON Field Ignore Test Entity Class
 * Demonstrates how to ignore specific fields during JSON serialization
 * Includes two ignore methods: class-level annotation and field-level annotation
 */
@JsonIgnoreProperties({"ignoredField1", "ignoredField2"})
public class TestJsonIgnoreBean {

    /**
     * Normal field
     * Field that participates in normal JSON serialization
     */
    private String normalField;

    /**
     * Field ignored by annotation
     * Field marked with @JsonIgnore annotation, will be ignored during JSON serialization
     */
    @JsonIgnore
    private String ignoredByAnnotation;

    /**
     * Field ignored by class annotation 1
     * Field configured to be ignored through @JsonIgnoreProperties class annotation
     */
    private String ignoredField1;

    /**
     * Field ignored by class annotation 2
     * Field configured to be ignored through @JsonIgnoreProperties class annotation
     */
    private String ignoredField2;

    /**
     * Nested object field
     * Demonstrates field ignoring in complex objects
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
     * Nested Ignore Test Entity Class
     * Used to demonstrate JSON field ignoring functionality in nested objects
     */
    public static class NestedIgnoreBean {
        /**
         * Normal field in nested object
         */
        private String normalField;

        /**
         * Ignored field in nested object
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