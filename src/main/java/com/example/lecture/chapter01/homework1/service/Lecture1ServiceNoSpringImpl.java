package com.example.lecture.chapter01.homework1.service;

import com.example.lecture.chapter01.homework1.repository.Lecture1RepositoryNoSpring;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lecture1ServiceNoSpringImpl implements Lecture1ServiceNoSpring {


    final private Lecture1RepositoryNoSpring lecture1RepositoryNoSpring;

    public Lecture1ServiceNoSpringImpl(Lecture1RepositoryNoSpring lecture1RepositoryNoSpring) {
        this.lecture1RepositoryNoSpring = lecture1RepositoryNoSpring;
    }

    @Override
    public void save(String key, String value) {
        lecture1RepositoryNoSpring.save(key,value);
    }

    @Override
    public void findByKey(String key) {
        lecture1RepositoryNoSpring.findByKey(key);
    }

    @Override
    public void homework(String key) {
       String value =  lecture1RepositoryNoSpring.findByKey(key);
       log.info("Lecture1 과제입니다." + value);
    }
}
