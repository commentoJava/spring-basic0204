package com.example.lecture.chap04.repository;

import com.example.lecture.chap04.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String productName);

}
