package com.paulo.minipicpay;

import com.paulo.minipicpay.model.*;

public class UserFixture {

    public UserFixture() {
        //Fixture constructor
    }

    public static User aPersonUser() {
        return User.Builder.aUser()
                .with(UserType.PERSON)
                .with(UserName.of("Paulo"))
                .with(Cpf.of("123.123.123.12"))
                .with(UserEmail.of("paulo@gmail.com"))
                .with(Password.of("111111111"))
                .build();
    }
}
