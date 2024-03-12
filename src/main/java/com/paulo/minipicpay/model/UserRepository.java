package com.paulo.minipicpay.model;

import java.math.BigDecimal;

public interface UserRepository {

    void insert(User user);
    void updateBalance(User user, BigDecimal amount);
    User findBy(Document document);
}
