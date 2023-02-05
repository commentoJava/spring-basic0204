package com.example.lecture.chapter01.homework1.repository;

import java.util.Map;

public interface Lecture1RepositoryNoSpring {

    Map<String,String> save(String key, String value);
    String findByKey(String key);
}
