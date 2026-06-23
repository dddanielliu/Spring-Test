package com.example.springtest.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @PostMapping
    public ResponseEntity<String> createProduct() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Product Created");
        
    }

    @GetMapping
    public ResponseEntity<String> getProduct() {
        return ResponseEntity.status(HttpStatus.OK).body("Get Product");
    }

    @PutMapping
    public ResponseEntity<String> updateProduct() {
        return ResponseEntity.status(HttpStatus.OK).body("Product Updated");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product Deleted");
    }
}
