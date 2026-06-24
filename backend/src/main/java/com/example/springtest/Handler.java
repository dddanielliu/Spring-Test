package com.example.springtest;

import org.springframework.http.ResponseEntity;

public interface Handler<I, O> {

    ResponseEntity<O> execute(I input);

}
