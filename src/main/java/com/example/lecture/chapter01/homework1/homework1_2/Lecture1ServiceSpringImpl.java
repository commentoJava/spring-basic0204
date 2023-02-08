package com.example.lecture.chapter01.homework1.homework1_2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lecture1ServiceSpringImpl implements Lecture1ServiceWithSpring{


    private final Lecture1RepositoryWithSpring repository;

    public Lecture1ServiceSpringImpl(Lecture1RepositoryWithSpring repository) {
        this.repository = repository;
    }

    @Override
    public void homwork(String key) {
        String val = repository.findById(key).orElse("COMMENTO");
        log.info("Lecture1 과제입니다. {}", val );
    }
}
