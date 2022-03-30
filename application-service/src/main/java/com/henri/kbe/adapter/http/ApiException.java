package com.henri.kbe.adapter.http;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
