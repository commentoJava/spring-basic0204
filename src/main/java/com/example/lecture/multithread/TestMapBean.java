package com.example.lecture.multithread;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class TestMapBean {

//    private static final Map<String, Integer> map = new HashMap<>();


    private static final Map<String, Integer> map = new ConcurrentHashMap<>();

    public Integer retrieveKey(String key) {

        log.info("\n key {} value : {}", key, map.get(key));
        map.putIfAbsent(key, 0);
        map.computeIfPresent(
            key, (k, value) -> value + 1
        );
        return map.get(key);
    }
}