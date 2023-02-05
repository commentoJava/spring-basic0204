package com.example.lecture.chapter01.homework1.service;


import com.example.lecture.chapter01.homework1.repository.Lecture1RepositoryWithSpring;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Lecture1ServiceWithSpringImpl implements  Lecture1ServiceWithSpring {

    private  final Lecture1RepositoryWithSpring lecture1RepositoryWithSpring;

    @Override
    public void save(String key, String value) {
        lecture1RepositoryWithSpring.save(key,value);
    }

    @Override
    public void homework(String key) {
        String value =  lecture1RepositoryWithSpring.findByKey(key);
        log.info("Lecture1 과제입니다." + value);
    }

}
