package com.itangcent.springboot.demo.common.constant;

public enum UserType {
    ADMIN(1),
    MEMBER(2),
    GUEST(3);

    private final int type;

    UserType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
} 