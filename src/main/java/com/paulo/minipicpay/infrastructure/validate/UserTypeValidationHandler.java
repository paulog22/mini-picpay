package com.paulo.minipicpay.infrastructure.validate;

import com.paulo.minipicpay.model.ValidateTransferHandler;
import com.paulo.minipicpay.model.exception.TransferNotAllowedException;
import com.paulo.minipicpay.model.User;
import com.paulo.minipicpay.model.UserType;

import java.math.BigDecimal;

public class UserTypeValidationHandler extends BaseValidationHandler {

    public UserTypeValidationHandler(ValidateTransferHandler next) {
        super(next);
    }

    @Override
    public void validate(User user, BigDecimal amount) {
        if (user.userType().equals(UserType.PERSON)) {
            next(user, amount);
            return;
        }
        throw new TransferNotAllowedException("Transfer only allowed for person user types");
    }
}
