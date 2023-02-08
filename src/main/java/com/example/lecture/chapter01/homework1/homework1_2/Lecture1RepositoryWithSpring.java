package com.example.lecture.chapter01.homework1.homework1_2;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public interface Lecture1RepositoryWithSpring {

    public void save(HashMap hashMap);

    public Optional<String> findById(String key);
}
