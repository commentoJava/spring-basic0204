package com.example.lecture.chapter01.homework_sh;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Lecture1ServiceImpl implements Lecture1ServiceNoSpring{

    private final Lecture1RepositoryImpl Lecture1Repository;

//    public Lecture1ServiceImpl() {
//    }

//    public Lecture1ServiceImpl(Lecture1RepositoryImpl Lecture1Repository){
//        this.Lecture1Repository = Lecture1Repository;
//    }

    public void findByKey(String key){
        String value = Lecture1Repository.findValue(key);

        if (value!=null) {
            log.info("\n Lecture1 과제입니다. key : {}, value : {}", key, value);
        } else {
            log.info("\n commento");

        }
    }

    public void insertByKey(String key, String value) {
        Lecture1Repository.insertValue(key, value);
    }

    public void homework(String key){
        findByKey(key);
    }

}
