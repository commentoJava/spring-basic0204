package com.example.lecture.chapter01.homework_sh;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lecture1ServiceSpringImpl implements Lecture1ServiceWithSpring{

    private final Lecture1RepositoryWithSpring Lecture1RepositoryWithSpring;

    @Override
    public void findByKey(String key) {
        String value = Lecture1RepositoryWithSpring.findByValue(key);

        if (value!=null) {
            log.info("\n Lecture2 과제입니다. key : {}, value : {}", key, value);
        } else {
            log.info("\n commento");
        }
    }


    @Override
    public void insertByKey(String key, String value) {
        Lecture1RepositoryWithSpring.insertByValue(key, value);
    }

    @Override
    public void homework2(String key) {
        findByKey(key);
    }
}
