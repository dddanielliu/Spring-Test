package com.example.springtest.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.product.model.Product;
import com.example.springtest.product.services.CreateProductService;
import com.example.springtest.product.services.DeleteProductService;
import com.example.springtest.product.services.GetProductService;
import com.example.springtest.product.services.UpdateProductService;

@RestController
public class ProductController {

    private final CreateProductService createProductService;
    private final GetProductService getProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;

    public ProductController(
        CreateProductService createProductService,
        GetProductService getProductService,
        UpdateProductService updateProductService,
        DeleteProductService deleteProductService
    ) {
        this.createProductService = createProductService;
        this.getProductService = getProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct() {
        return createProductService.execute(null);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct() {
        return getProductService.execute(null);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct() {
        return updateProductService.execute(null);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct() {
        return deleteProductService.execute(null);
    }
}
