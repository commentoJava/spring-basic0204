package com.example.lecture.homework1_1.service;

public interface Lecture1ServiceNoSpring {
    void save(String key, String value);
    String findByKey(String key);
    void homework(String key);
}
