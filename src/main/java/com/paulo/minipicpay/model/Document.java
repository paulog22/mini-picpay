package com.paulo.minipicpay.model;

import com.paulo.minipicpay.model.exception.InvalidCpfValueException;

public class Document {

    private final String value;

    private Document(String value) {
        this.value = value;
    }

    public static Document of(String value) {
        if (isValid(value)) {
            return new Document(value);
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
