package com.example.lecture.chapter01.homework1.repository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
@RequiredArgsConstructor
@Slf4j
public class Lecture1RepositoryWithSpringImpl implements  Lecture1RepositoryWithSpring {

    private static final Map<String, String> store = new HashMap<>();

    @Override
    public Map<String, String> save(String key, String value) {
        store.put(key, value);
        return store;
    }

    @Override
    public String findByKey(String key) {
        if (store.get(key).isEmpty()) {
            return "COMMENTO";
        }
        return key;
    }
}