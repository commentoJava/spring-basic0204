package com.example.lecture.chapter01.homework_sh;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
public class Lecture1RepositoryImpl implements Lecture1RepositoryNoSpring{

    HashMap<String, String> prac_db = new HashMap<>();


    @Override
    public String findValue(String key) {
        String value = prac_db.get(key);
        return value;
    }


    @Override
    public void insertValue(String key, String value) {
        prac_db.put(key, value);
//        log.info("\n key : {}, value : {}", key, value);
    }

}
