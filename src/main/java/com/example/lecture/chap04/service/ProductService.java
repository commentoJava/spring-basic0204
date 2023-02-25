package com.example.lecture.chap04.service;

import com.example.lecture.chap04.domain.Product;
import com.example.lecture.chap04.dto.ProductCreateDto;
import com.example.lecture.chap04.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 상품입니다"));
    }

    public Long createProduct(ProductCreateDto dto){

        return productRepository.save(ProductCreateDto.from(dto)).getId();
    }

}
