package com.example.springtest.product.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springtest.Query;
import com.example.springtest.exceptions.ProductNotFoundException;
import com.example.springtest.product.ProductRepository;
import com.example.springtest.product.model.Product;
import com.example.springtest.product.model.ProductDTO;

@Service
public class GetProductService implements Query<Integer, ProductDTO>{
    private final ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(GetProductService.class);
    
    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDTO> execute(Integer input) {

        logger.info("Executing {} input : {}", getClass(), input);

        // account for null value if db can't find it
        Optional<Product> productOptional = productRepository.findById(input);
        if (productOptional.isPresent()){
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        
        throw new ProductNotFoundException();
    }

}
