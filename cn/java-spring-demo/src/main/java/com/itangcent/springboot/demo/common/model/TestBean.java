package com.itangcent.springboot.demo.common.model;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * 测试Bean类
 * 用于演示Jackson的@JsonView注解功能
 * 可以根据不同的视图展示不同的字段
 */
public class TestBean {
    /**
     * 视图A可见的字段
     * 只在ViewA视图下序列化
     */
    @JsonView(ViewA.class)
    private String aaAaa;

    /**
     * 视图B可见的字段
     * 只在ViewB视图下序列化
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
     * 视图A标记接口
     * 用于@JsonView注解标记ViewA可见的字段
     */
    public interface ViewA {}

    /**
     * 视图B标记接口
     * 用于@JsonView注解标记ViewB可见的字段
     */
    public interface ViewB {}
} 