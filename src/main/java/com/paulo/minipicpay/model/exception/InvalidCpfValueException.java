package com.paulo.minipicpay.model.exception;

public class InvalidCpfValueException extends RuntimeException {

    public InvalidCpfValueException(String message) {
        super(message);
    }
}
