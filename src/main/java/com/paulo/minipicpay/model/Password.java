package com.paulo.minipicpay.model;

public class Password {

    private final String value;

    private Password(String value) {
        this.value = value;
    }

    public static Password of(String value) {
        return new Password(value);
    }

    public String value() {
        return value;
    }
}
