package com.paulo.minipicpay.model;

public class User {

    private final UserType userType;
    private final UserName name;
    private final String cpf;
    private final String email;
    private final String password;

    public User(UserType userType, UserName name, String cpf, String email, String password) {
        this.userType = userType;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        validate(this);
    }

    private void validate(User user) {
        // cpf, email
    }

    public UserType userType() {
        return userType;
    }

    public UserName name() {
        return name;
    }

    public String cpf() {
        return cpf;
    }


    public String email() {
        return email;
    }

    public String password() {
        return password;
    }
}
