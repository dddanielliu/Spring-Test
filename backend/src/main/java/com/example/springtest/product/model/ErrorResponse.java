package com.example.springtest.product.model;

import lombok.Getter;

@Getter
public class ErrorResponse {
    // can make your error message as big as you want with more properties
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
