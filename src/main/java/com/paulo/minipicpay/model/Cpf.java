package com.paulo.minipicpay.model;

public class Cpf {

    private final String value;

    private Cpf(String value) {
        this.value = value;
    }

    public static Cpf of(String value) {
        if (!isValid(value)) {
            throw new InvalidCpfValueException("Invalid Cpf value");
        }
        return new Cpf(value);
    }

    public static boolean isValid(String value) {
        return true;
    }

    public String value() {
        return value;
    }
}
