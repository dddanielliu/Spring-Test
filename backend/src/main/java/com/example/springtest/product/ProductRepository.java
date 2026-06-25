package com.example.springtest.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springtest.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // spring data jpa
    List<Product> findByNameContaining(String name);
}
