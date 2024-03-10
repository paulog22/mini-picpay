package com.paulo.minipicpay.model;

public class InvalidCpfValueException extends RuntimeException {

    public InvalidCpfValueException(String message) {
        super(message);
    }
}
