package com.paulo.minipicpay.infrastructure.rest;

import com.paulo.minipicpay.model.exception.InvalidCpfValueException;
import com.paulo.minipicpay.model.exception.InvalidUserTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCpfValueException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCpfValueException(InvalidCpfValueException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND, "Customer not found.");
    }

    @ExceptionHandler(InvalidUserTypeException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidUserTypeException(InvalidUserTypeException ex) {
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, "Invalid whitelist IP.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error.");
    }

    private ResponseEntity<ApiErrorResponse> buildErrorResponse(Exception ex, HttpStatus status, String message) {
        ApiErrorResponse response = new ApiErrorResponse(status.value(), message);
        return new ResponseEntity<>(response, status);
    }
}
