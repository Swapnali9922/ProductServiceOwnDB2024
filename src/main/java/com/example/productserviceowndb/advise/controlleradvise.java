package com.example.productserviceowndb.advise;

import com.example.productserviceowndb.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class controlleradvise {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> getProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
    }
}
