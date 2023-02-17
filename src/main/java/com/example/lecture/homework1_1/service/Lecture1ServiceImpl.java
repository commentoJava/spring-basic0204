package com.example.lecture.homework1_1.service;

import com.example.lecture.homework1_1.repository.Lecture1RepositoryNoSpring;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Lecture1ServiceImpl implements Lecture1ServiceNoSpring{
    private final Lecture1RepositoryNoSpring lecture1RepositoryNoSpring;

    public Lecture1ServiceImpl(Lecture1RepositoryNoSpring lecture1RepositoryNoSpring) {
        this.lecture1RepositoryNoSpring = lecture1RepositoryNoSpring;
    }

    @Override
    public void save(String key, String value) {
        lecture1RepositoryNoSpring.save(key, value);
    }

    @Override
    public String findByKey(String key) {
        String value = lecture1RepositoryNoSpring.findByKey(key);
        if (value==null)
            value = "COMMENTO";

        return value;
    }

    @Override
    public void homework(String key) {
        String value = lecture1RepositoryNoSpring.findByKey(key);
        log.info("Lecture 1 과제 입니다. {}", value);
    }
}
