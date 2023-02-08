package com.example.lecture.chapter01.homework1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class noSpringSingletonDB {

    private ConcurrentMap<String, String> noSpringDataList = new ConcurrentHashMap<>();

    private noSpringSingletonDB() {

    }
    private static final noSpringSingletonDB getInstance = new noSpringSingletonDB();

    public static noSpringSingletonDB getInstance() {
        return getInstance;
    }

    public String getNoSpringDataList(String id) {
        return noSpringDataList.get(id);
    }

    public noSpringSingletonDB setNoSpringDataList(ConcurrentMap<String, String> noSpringDataList) {
        this.noSpringDataList = noSpringDataList;
        return  this;
    }
}
