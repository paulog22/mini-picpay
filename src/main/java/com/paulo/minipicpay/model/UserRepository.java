package com.paulo.minipicpay.model;

public interface UserRepository {

    void insert(User user);
    void updateBalance(User user, Double amount, TransferType transferType);
    User findBy(Cpf cpf);
}
