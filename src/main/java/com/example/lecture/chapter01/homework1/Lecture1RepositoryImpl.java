package com.example.lecture.chapter01.homework1;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public class Lecture1RepositoryImpl implements Lecture1RepositoryNoSpring{

    noSpringSingletonDB instance = noSpringSingletonDB.getInstance();
    @Override
    public void save(ConcurrentMap concurrentMap) {
        instance.setNoSpringDataList(concurrentMap);
    }

    @Override
    public Optional<String> findById(String id) {
        return Optional.ofNullable(instance.getNoSpringDataList(id));
    }


}
