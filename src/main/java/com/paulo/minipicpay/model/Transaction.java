package com.paulo.minipicpay.model;

import java.math.BigDecimal;

public class Transaction {

    private final User sender;
    private final User receiver;
    private final BigDecimal amount;

    public Transaction(User sender, User receiver, BigDecimal amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public User sender() {
        return sender;
    }

    public User receiver() {
        return receiver;
    }

    public BigDecimal amount() {
        return amount;
    }
}
