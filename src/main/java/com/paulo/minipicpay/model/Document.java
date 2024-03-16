package com.paulo.minipicpay.model;

import com.paulo.minipicpay.model.exception.InvalidCpfValueException;

import java.util.Objects;

public class Document {

    private final String value;

    private Document(String value) {
        this.value = value;
    }

    public static Document of(String value) {
        if (isValid(value)) {
            return new Document(value);
        }
        throw new InvalidCpfValueException("Invalid Document value");
    }

    public static boolean isValid(String value) {
        return value.trim().replaceAll("[.-]", "").matches("\\d{11}");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(value, document.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
