package com.example.lecture.chapter01.homework_sh;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class Lecture1RepositorySpringImpl implements Lecture1RepositoryWithSpring{

    HashMap<String, String> prac_db_2 = new HashMap<>();

    @Override
    public String findByValue(String key) {
        String value = prac_db_2.get(key);
        return value;
    }

    @Override
    public void insertByValue(String key, String value) {
        prac_db_2.put(key, value);
    }

}
