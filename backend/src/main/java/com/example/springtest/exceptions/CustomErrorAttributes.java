// package com.example.springtest.exceptions;

// import java.util.Map;

// import org.springframework.boot.web.error.ErrorAttributeOptions;
// import org.springframework.boot.webmvc.error.DefaultErrorAttributes;
// import org.springframework.stereotype.Component;
// import org.springframework.web.context.request.WebRequest;

// @Component
// public class CustomErrorAttributes extends DefaultErrorAttributes {
//     @Override
//     public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
//         Map<String, Object> attributes = super.getErrorAttributes(webRequest, options);
//         Throwable error = getError(webRequest);
//         if (error != null) {
//             attributes.put("message", error.getMessage());
//         }
//         return attributes;
//     }
// }
