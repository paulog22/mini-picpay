package com.paulo.minipicpay.model;

public class InvalidUserTypeException extends RuntimeException {

    public InvalidUserTypeException(String message) {
        super(message);
    }
}
