package com.paulo.minipicpay.model;

public class UserName {

    private final String value;

    private UserName(String value) {
        this.value = value;
    }

    public static UserName of(String value) {
        return new UserName(value);
    }
}
