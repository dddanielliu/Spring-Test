package com.example.springtest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.springtest.exceptions.ProductNotFoundException;
import com.example.springtest.product.ProductRepository;
import com.example.springtest.product.model.Product;
import com.example.springtest.product.model.ProductDTO;
import com.example.springtest.product.services.GetProductService;

public class GetProductServiceTest {

    @Mock // what to mock the response of -> need this dependency to run the test
    private ProductRepository productRepository;

    @InjectMocks // the thing we are testing
    private GetProductService getProductService;

    @BeforeEach // things we need before the test runs to set up properly
    public void setup(){
        // initializes the repository & the service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_product_exists_when_get_product_service_return_product_dto(){
        // Given
        Product product = new Product();
        product.setId(1);
        product.setName("Product Name");
        product.setDescription("Product Description which is at least 20 chars");
        product.setPrice(9.99);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // When
        ResponseEntity<ProductDTO> response = getProductService.execute(1);

        // Then
        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response);
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    public void given_product_does_not_exist_when_get_product_service_throw_product_not_found_exception(){
        // Given
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productRepository, times(1)).findById(1);
    }

}
