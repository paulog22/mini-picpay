package com.paulo.minipicpay.model;

import com.paulo.minipicpay.model.exception.InvalidCpfValueException;

public class Cpf {

    private final String value;

    private Cpf(String value) {
        this.value = value;
    }

    public static Cpf of(String value) {
        if (isValid(value)) {
            return new Cpf(value);
        }
        throw new InvalidCpfValueException("Invalid Cpf value");
    }

    public static boolean isValid(String value) {
        return value.trim().replaceAll("[.-]", "").matches("\\d{11}");
    }

    public String value() {
        return value;
    }
}
