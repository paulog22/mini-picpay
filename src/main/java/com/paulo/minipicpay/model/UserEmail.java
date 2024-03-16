package com.paulo.minipicpay.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEmail email = (UserEmail) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
