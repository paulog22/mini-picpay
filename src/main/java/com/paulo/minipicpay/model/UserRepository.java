package com.paulo.minipicpay.model;

public interface UserRepository {

    void insert(User user);
    User findBy(UserName name);
    User findBy(Cpf cpf);
}
