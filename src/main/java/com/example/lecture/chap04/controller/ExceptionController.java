package com.example.lecture.chap04.controller;

import com.example.lecture.chap04.dto.ErrorResponse;
import com.example.lecture.chap04.exception.ProductException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chap04")
@Slf4j
public class ExceptionController {

    @GetMapping("/product/{productName}")
    public ProductExDto getProduct(@PathVariable String productName){
        if(productName.equals("no"))
            throw new RuntimeException("잘못된 상품명");
        if(productName.equals("bad"))
            throw new IllegalArgumentException("잘못된 유저 입력");
        if(productName.equals("ex"))
            throw new ProductException("상품 오류");
        return new ProductExDto("정상 상품 이름","정상 상품 아이디");
    }

    @Data
    @AllArgsConstructor
    static class ProductExDto{
        private String productName;
        private String productId;
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ErrorResponse illegalExceptionHandler(IllegalArgumentException e){
//        log.error("\n illegalErrorHandler ex = ",e);
//        return new ErrorResponse("BAD_REQUEST",e.getMessage());
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<?> productExceptionHandler(ProductException e){
//        log.error("\n ProductException ex = ", e);
//        return new ResponseEntity<>(new ErrorResponse("ex",e.getMessage()),HttpStatus.BAD_REQUEST);
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler
//    public ErrorResponse runtimeExceptionHandler(RuntimeException e){
//        log.error("\n RuntimeException ex = ",e);
//        return new ErrorResponse("no", e.getMessage());
//    }
}
