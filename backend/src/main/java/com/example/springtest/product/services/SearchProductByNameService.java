package com.example.springtest.product.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springtest.Query;
import com.example.springtest.product.ProductRepository;
import com.example.springtest.product.model.ProductDTO;

@Service
public class SearchProductByNameService implements Query<String, List<ProductDTO>> {

    private final ProductRepository productRepository;

    public SearchProductByNameService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        return ResponseEntity.ok(productRepository.findByNameContaining(name)
            .stream()
            .map(ProductDTO::new)
            .toList()
        );
    }

}
