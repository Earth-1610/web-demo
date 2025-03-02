package com.itangcent.springboot.demo.common.model;

/**
 * Test Log Bean Class
 * Used to demonstrate the usage of the transient keyword
 * Contains examples of handling sensitive information
 */
public class TestLogBean {
    /**
     * Username
     * Normal serialization and persistence
     */
    private String userName;

    /**
     * Password
     * Marked with transient, excluded from serialization
     * Used to protect sensitive information
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