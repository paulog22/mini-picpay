package com.paulo.minipicpay.model;

public class UserEmail {

    private final String value;

    private UserEmail(String value) {
        this.value = value;
    }

    public static UserEmail of(String value) {
        return new UserEmail(value);
    }

    public String value() {
        return value;
    }
}
