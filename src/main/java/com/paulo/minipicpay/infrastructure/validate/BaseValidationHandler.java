package com.paulo.minipicpay.infrastructure.validate;

import com.paulo.minipicpay.model.User;
import com.paulo.minipicpay.model.ValidateTransferHandler;

public abstract class BaseValidationHandler implements ValidateTransferHandler {

    private final ValidateTransferHandler next;

    protected BaseValidationHandler(ValidateTransferHandler next) {
        this.next = next;
    }

    protected void next(User user, Double amount) {
        next.validate(user, amount);
    }
}
