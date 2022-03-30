package com.henri.kbe.adapter.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleException(ApiException e) {
        return ResponseEntity.badRequest().body(e.getLocalizedMessage());
    }
}
