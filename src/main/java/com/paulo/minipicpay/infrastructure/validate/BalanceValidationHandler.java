package com.paulo.minipicpay.infrastructure.validate;

import com.paulo.minipicpay.model.ValidateTransferHandler;
import com.paulo.minipicpay.model.User;
import com.paulo.minipicpay.model.exception.InsufficientBalanceException;

public class BalanceValidationHandler extends BaseValidationHandler {

    public BalanceValidationHandler(ValidateTransferHandler next) {
        super(next);
    }

    @Override
    public void validate(User user, Double amount) {
        if (haveBalance(user, amount)) {
            next(user, amount);
            return;
        }
        throw new InsufficientBalanceException("Insufficient balance - Balance: R$" + user.balance());
    }

    private boolean haveBalance(User user, Double amount) {
        return user.balance() - amount >= 0.00;
    }
}
