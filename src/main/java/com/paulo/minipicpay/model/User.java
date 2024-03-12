package com.paulo.minipicpay.model;

public class User {

    private final UserType userType;
    private final UserName name;
    private final Document document;
    private final UserEmail email;
    private final Password password;
    private Double balance;

    public User(Builder builder) {
        this.userType = builder.userType;
        this.name = builder.name;
        this.document = builder.document;
        this.email = builder.email;
        this.password = builder.password;
        this.balance = 0D;
    }

    public void increaseBalance(Double amount) {
        this.balance = balance + amount;
    }

    public void decreaseBalance(Double amount) {
        this.balance = balance - amount;
    }

    public UserType userType() {
        return userType;
    }

    public UserName name() {
        return name;
    }

    public Document cpf() {
        return document;
    }

    public UserEmail email() {
        return email;
    }

    public Password password() {
        return password;
    }

    public Double balance() {
        return balance;
    }

    public static class Builder {
        private UserType userType;
        private UserName name;
        private Document document;
        private UserEmail email;
        private Password password;

        public static Builder aUser() {
            return new Builder();
        }

        public Builder with(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder with(UserName name) {
            this.name = name;
            return this;
        }

        public Builder with(Document document) {
            this.document = document;
            return this;
        }

        public Builder with(UserEmail email) {
            this.email = email;
            return this;
        }

        public Builder with(Password password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
