package com.example.lecture.chapter01.homework1.homework1_2;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

public class SpringSingletonDB {
    HashMap<String, String> springData = new HashMap();

    public String getSpringData(String key) {
        return springData.get(key);
    }

    public SpringSingletonDB setSpringData(HashMap springData) {
        this.springData = springData;
        return this;
    }
}
