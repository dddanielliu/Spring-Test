package com.example.springtest.product.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.springtest.Command;
import com.example.springtest.exceptions.ProductNotValidException;
import com.example.springtest.product.ProductRepository;
import com.example.springtest.product.model.Product;
import com.example.springtest.product.model.ProductDTO;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {

        if (!StringUtils.hasLength(product.getName())) {
            throw new ProductNotValidException("Product name is required");
        }

        if (!StringUtils.hasLength(product.getDescription())) {
            throw new ProductNotValidException("Product description is required");
        }

        if (product.getDescription().length() < 20){
            throw new ProductNotValidException("Product description must be at least 20 characters long");
        }

        if (product.getPrice() == null || product.getPrice() <= 0.00) {
            throw new ProductNotValidException("Pice must be greater than 0.00");
        }

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }
}
