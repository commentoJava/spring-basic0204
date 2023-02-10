package com.example.lecture.homework1_1.repository;

import com.example.lecture.homework1_1.Lecture1DB;

import java.util.HashMap;

public class Lecture1RepositoryImpl implements Lecture1RepositoryNoSpring{
    HashMap<String, String> dataMap = Lecture1DB.getInstance();

    @Override
    public void save(String key, String value) {
        dataMap.put(key, value);
    }

    @Override
    public String findByKey(String key) {
        return dataMap.get(key);
    }
}
