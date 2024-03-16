package com.paulo.minipicpay.infrastructure.rest;

import com.paulo.minipicpay.model.*;

import java.math.BigDecimal;

public class UserView {

    private final String userType;
    private final String name;
    private final String document;
    private final String email;
    private final BigDecimal balance;

    public UserView(User user) {
        this.userType = user.userType().name();
        this.name = user.name().value();
        this.document = user.document().value();
        this.email = user.email().value();
        this.balance = user.balance();
    }
}
