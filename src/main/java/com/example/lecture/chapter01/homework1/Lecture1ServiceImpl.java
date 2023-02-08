package com.example.lecture.chapter01.homework1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lecture1ServiceImpl implements Lecture1ServiceNoSpring{

    @Override
    public void homework(String key) {
        Lecture1RepositoryNoSpring repositoryNoSpring = new Lecture1RepositoryImpl();
        String val = repositoryNoSpring.findById(key).orElse("COMMENTO");
        log.info("Lecture1 과제입니다. {}", val);
    }
}
