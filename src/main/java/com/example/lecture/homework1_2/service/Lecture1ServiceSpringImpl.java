package com.example.lecture.homework1_2.service;

import com.example.lecture.homework1_2.repository.Lecture1RepositoryWithSpring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Lecture1ServiceSpringImpl implements Lecture1ServiceWithSpring {
    private final Lecture1RepositoryWithSpring lecture1RepositoryWithSpring;

    public Lecture1ServiceSpringImpl(Lecture1RepositoryWithSpring lecture1RepositoryWithSpring) {
        this.lecture1RepositoryWithSpring = lecture1RepositoryWithSpring;
    }

    @Override
    public void save(String key, String value) {
        lecture1RepositoryWithSpring.save(key, value);
    }

    @Override
    public String findByKey(String key) {
        String value = lecture1RepositoryWithSpring.findByKey(key);
        if(value==null)
            value = "COMMENTO";
        return value;
    }

    @Override
    public void homework(String key) {
        String value = lecture1RepositoryWithSpring.findByKey(key);
        log.info("Lecture 1 과제 입니다. {}", value);
    }
}
