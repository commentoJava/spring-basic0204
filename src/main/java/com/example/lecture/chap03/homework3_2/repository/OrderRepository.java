package com.example.lecture.chap03.homework3_2.repository;

import com.example.lecture.chap03.homework3_2.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
