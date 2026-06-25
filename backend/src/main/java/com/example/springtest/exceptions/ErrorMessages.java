package com.example.springtest.exceptions;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product not found"),
    NAME_REQUIRED("Product name is required"),
    DESCRIPTION_REQUIRED("Product description is required"),
    DESCRIPTION_LENGTH("Description must be at least 20 characters long"),
    PRICE_CANNOT_BE_NEGATIVE("Price must be greater than 0.00");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
