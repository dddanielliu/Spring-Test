package com.example.springtest.product.validators;

import org.springframework.util.StringUtils;

import com.example.springtest.exceptions.ErrorMessages;
import com.example.springtest.exceptions.ProductNotValidException;
import com.example.springtest.product.model.Product;

public class ProductValidator {
    private ProductValidator(){
    }

    public static void execute(Product product) {
        if (!StringUtils.hasLength(product.getName())) {
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }

        if (!StringUtils.hasLength(product.getDescription())) {
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_REQUIRED.getMessage());
        }

        if (product.getDescription().length() < 20){
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_LENGTH.getMessage());
        }

        if (product.getPrice() == null || product.getPrice() <= 0.00) {
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNOT_BE_NEGATIVE.getMessage());
        }
    }
}
