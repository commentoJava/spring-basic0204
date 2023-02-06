package com.example.lecture.chapter01.homework1.repository;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class Lecture11RepositoryImpl implements Lecture1RepositoryNoSpring {

    private static final Map<String, String> store = new HashMap<>();

    @Override
    public Map<String, String> save(String key,String value) {
        store.put(key,value);
        log.info("저장 완료" + key + value);
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
