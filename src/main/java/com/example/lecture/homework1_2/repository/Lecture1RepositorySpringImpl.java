package com.example.lecture.homework1_2.repository;

import com.example.lecture.homework1_2.Lecture1DB;
import org.springframework.stereotype.Repository;

@Repository
public class Lecture1RepositorySpringImpl implements Lecture1RepositoryWithSpring{

    private final Lecture1DB lecture1DB;

    public Lecture1RepositorySpringImpl(Lecture1DB lecture1DB) {
        this.lecture1DB = lecture1DB;
    }

    @Override
    public void save(String key, String value) {
        lecture1DB.put(key, value);
    }

    @Override
    public String findByKey(String key) {
        return lecture1DB.get(key);
    }
}
