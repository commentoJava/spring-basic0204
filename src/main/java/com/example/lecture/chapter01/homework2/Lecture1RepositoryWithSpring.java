package com.example.lecture.chapter01.homework2;

import java.util.HashMap;
import java.util.Map;

public interface Lecture1RepositoryWithSpring {

    Map<String, String> repo = new HashMap<String, String>();

    default String LoadInfo(String key) {
        return repo.get(key);
    }
    default void SaveInfo(String key, String value) {
        repo.put(key,value);
    }


}
