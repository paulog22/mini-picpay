package com.paulo.minipicpay.model.exception;

public class TransferNotAllowedException extends RuntimeException {

    public TransferNotAllowedException(String message) {
        super(message);
    }
}
