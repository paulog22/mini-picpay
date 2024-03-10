package com.paulo.minipicpay.model;

import com.paulo.minipicpay.model.exception.InvalidUserTypeException;

public enum UserType {

    PERSON, STORE;

    public static UserType from(String userType) {
        for (UserType item : values()) {
            if (item.name().equalsIgnoreCase(userType)) {
                return item;
            }
        }
        throw new InvalidUserTypeException("Invalid User Type! - Availables: PERSON, STORE");
    }
}
