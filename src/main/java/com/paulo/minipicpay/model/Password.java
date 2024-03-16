package com.paulo.minipicpay.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
