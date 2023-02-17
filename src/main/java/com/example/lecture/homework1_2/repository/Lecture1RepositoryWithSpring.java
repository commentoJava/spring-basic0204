package com.example.lecture.homework1_2.repository;

public interface Lecture1RepositoryWithSpring {
    void save(String key, String value);
    String findByKey(String key);
}
