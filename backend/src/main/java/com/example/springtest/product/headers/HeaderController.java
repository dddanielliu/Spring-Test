package com.example.springtest.product.headers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.product.model.Product;

@RestController
public class HeaderController {
    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader String region){
        // normally abstract this out into a service class -> but skipping that for now for simplicity
        if (region.equals("US")) return "BALD EAGLD FREEFOM";

        if (region.equals("CAN")) return "Myple Syrup";

        return "Country Not Supported";
    }

    @GetMapping(value = "/header/product", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> getProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("super great product");
        product.setDescription("The greatest product you'll ever see ever");
        return ResponseEntity.ok(product);
    }
}
