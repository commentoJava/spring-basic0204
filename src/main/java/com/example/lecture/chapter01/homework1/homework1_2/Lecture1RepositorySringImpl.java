package com.example.lecture.chapter01.homework1.homework1_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public class Lecture1RepositorySringImpl implements Lecture1RepositoryWithSpring{


    private static SpringSingletonDB singletonDB;

    public Lecture1RepositorySringImpl(SpringSingletonDB SpringSingletonDB) {
        this.singletonDB = SpringSingletonDB;
    }

    @Override
    public void save(HashMap map) {
        singletonDB.setSpringData(map);
    }

    @Override
    public Optional<String> findById(String key) {
        return Optional.ofNullable(singletonDB.getSpringData(key));
    }
}
