package com.example.springtest.product.headers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {
    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader String region){
        // normally abstract this out into a service class -> but skipping that for now for simplicity
        if (region.equals("US")) return "BALD EAGLD FREEFOM";

        if (region.equals("CAN")) return "Myple Syrup";

        return "Country Not Supported";
    }
}
