package com.example.lecture.homework1_2.service;

public interface Lecture1ServiceWithSpring {
    void save(String key, String value);
    String findByKey(String key);
    void homework(String key);
}
