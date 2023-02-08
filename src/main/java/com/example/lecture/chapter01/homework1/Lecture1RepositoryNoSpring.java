package com.example.lecture.chapter01.homework1;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public interface Lecture1RepositoryNoSpring {

    public void save(ConcurrentMap concurrentMap);

    public Optional<String> findById(String id);
}
