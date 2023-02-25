package com.example.lecture.chap04.exception;

public class ProductException extends RuntimeException{

    public ProductException() {
    }

    public ProductException(String message) {
        super(message);
    }
}
