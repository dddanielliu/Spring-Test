package com.example.springtest.product.services;

import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springtest.Command;
import com.example.springtest.exceptions.ProductNotFoundException;
import com.example.springtest.product.ProductRepository;
import com.example.springtest.product.model.Product;
import com.example.springtest.product.model.ProductDTO;
import com.example.springtest.product.model.UpdateProductCommand;
import com.example.springtest.product.validators.ProductValidator;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CachePut(value="productCache", key="#command.getId()")
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if (productOptional.isPresent()) {
            Product product = command.getProduct();
            product.setId(command.getId());
            ProductValidator.execute(product);
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        
        throw new ProductNotFoundException();
    }
}
