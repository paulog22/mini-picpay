package com.paulo.minipicpay.application;

public record CreateUserRequest(String userType, String name, String document, String email, String password) {

}
