package com.example.lecture.chap03.homework3_2.repository;

import com.example.lecture.chap03.homework3_2.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
