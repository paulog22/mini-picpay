package com.paulo.minipicpay;

import com.paulo.minipicpay.model.*;

import java.math.BigDecimal;

public class UserFixture {

    public UserFixture() {
        //Fixture constructor
    }

    public static User aPersonUser() {
        return User.Builder.aUser()
                .with(UserType.PERSON)
                .with(UserName.of("Paulo"))
                .with(Document.of("123.123.123.12"))
                .with(UserEmail.of("paulo@gmail.com"))
                .with(Password.of("111111111"))
                .with(BigDecimal.valueOf(1000))
                .build();
    }

    public static User aStoreUser() {
        return User.Builder.aUser()
                .with(UserType.STORE)
                .with(UserName.of("Paulo"))
                .with(Document.of("111.111.111.11"))
                .with(UserEmail.of("paulo@gmail.com"))
                .with(Password.of("111111111"))
                .with(BigDecimal.valueOf(100.1))
                .build();
    }
}
