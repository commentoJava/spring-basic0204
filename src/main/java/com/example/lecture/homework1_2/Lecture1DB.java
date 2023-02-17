package com.example.lecture.homework1_2;

import java.util.HashMap;

public class Lecture1DB {
    HashMap<String, String> dataMap = new HashMap<>();

    public void put(String key, String value){
        dataMap.put(key, value);
    }

    public String get(String key){
        return dataMap.get(key);
    }
}
