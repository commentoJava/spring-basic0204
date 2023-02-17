package com.example.lecture.homework1_1;

import java.util.HashMap;

public class Lecture1DB {
    private static final HashMap<String, String> dataMap = new HashMap<>();

    public static HashMap<String, String> getInstance(){
        return dataMap;
    }
}
