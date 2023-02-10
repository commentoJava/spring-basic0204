package com.example.lecture.chapter01.homework1;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

public interface Lecture1RepositoryNoSpring {

    Map<String, String> repo = new HashMap<String, String>();

    default String LoadInfo(String key) {
        return repo.get(key);
    }
    default void SaveInfo(String key, String value) {
        repo.put(key,value);
    }


}
