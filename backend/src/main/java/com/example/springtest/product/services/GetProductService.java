package com.example.springtest.product.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springtest.Query;
import com.example.springtest.product.ProductRepository;
import com.example.springtest.product.model.Product;

@Service
public class GetProductService implements Query<Void, List<Product>> {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> execute(Void input) {
        List<Product> products = productRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
