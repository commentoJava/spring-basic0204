package com.example.lecture.homework1_1.repository;

public interface Lecture1RepositoryNoSpring {
    void save(String key, String value);
    String findByKey(String key);
}
