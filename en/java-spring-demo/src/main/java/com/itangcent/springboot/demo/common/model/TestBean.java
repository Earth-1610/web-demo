package com.itangcent.springboot.demo.common.model;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Test Bean Class
 * Used to demonstrate Jackson's @JsonView annotation functionality
 * Can display different fields based on different views
 */
public class TestBean {
    /**
     * Field visible in View A
     * Only serialized under ViewA view
     */
    @JsonView(ViewA.class)
    private String aaAaa;

    /**
     * Field visible in View B
     * Only serialized under ViewB view
     */
    @JsonView(ViewB.class)
    private String aaBbb;

    public String getAaAaa() {
        return aaAaa;
    }

    public void setAaAaa(String aaAaa) {
        this.aaAaa = aaAaa;
    }

    public String getAaBbb() {
        return aaBbb;
    }

    public void setAaBbb(String aaBbb) {
        this.aaBbb = aaBbb;
    }

    /**
     * View A Marker Interface
     * Used with @JsonView annotation to mark fields visible in ViewA
     */
    public interface ViewA {}

    /**
     * View B Marker Interface
     * Used with @JsonView annotation to mark fields visible in ViewB
     */
    public interface ViewB {}
} 