package com.itangcent.springboot.demo.common.model;

/**
 * 测试日志Bean类
 * 用于演示transient关键字的使用
 * 包含敏感信息处理示例
 */
public class TestLogBean {
    /**
     * 用户名
     * 正常序列化和持久化
     */
    private String userName;

    /**
     * 密码
     * 使用transient修饰，不参与序列化
     * 用于保护敏感信息
     */
    private transient String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} 