package com.paulo.minipicpay.model;

import java.math.BigDecimal;

public interface ValidateTransferHandler {

    void validate(User user, BigDecimal amount);
}
