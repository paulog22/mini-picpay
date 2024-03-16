package com.paulo.minipicpay.infrastructure.rest;

import java.util.Objects;

public class ApiErrorResponse {

    private final Integer status;
    private final String message;

    public ApiErrorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public boolean equals(Object other) {
        return other != null && getClass().equals(other.getClass()) && equalsCasted((ApiErrorResponse) other);
    }

    private boolean equalsCasted(ApiErrorResponse other) {
        return Objects.equals(status, other.status) &&
                Objects.equals(message, other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }
}
