package com.paulo.minipicpay.model;

import java.util.Objects;

public class UserName {

    private final String value;

    private UserName(String value) {
        this.value = value;
    }

    public static UserName of(String value) {
        return new UserName(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(value, userName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
