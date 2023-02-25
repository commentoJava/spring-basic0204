package com.example.lecture.chap04.controller;

import com.example.lecture.chap04.dto.ProductCreateDto;
import com.example.lecture.chap04.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductInfo(@PathVariable(name = "id") Long productId) {
        return ResponseEntity.ok(new Result(productService.findProductById(productId)));
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductCreateDto dto) {
        return ResponseEntity.ok(new Result(productService.createProduct(dto)));
    }

    @Data
    @Builder
    @AllArgsConstructor
    static class Result<T> {
        T body;
    }
}
