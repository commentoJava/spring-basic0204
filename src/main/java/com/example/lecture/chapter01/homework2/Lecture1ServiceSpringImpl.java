package com.example.lecture.chapter01.homework2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lecture1ServiceSpringImpl implements Lecture1ServiceWithSpring {

    private final Lecture1RepositorySpringImpl lecture1Repository;

    public Lecture1ServiceSpringImpl(Lecture1RepositorySpringImpl lecture1Repository) {
        this.lecture1Repository = lecture1Repository;
    }

    @Override
    public void saveData(String key, String value) {
        lecture1Repository.SaveInfo(key, value);
        log.info("<데이터 저장> {}: {}", key, value);
    }

    @Override
    public void findData(String key) {
        lecture1Repository.LoadInfo(key);
        log.info("<데이터 출력> {}: {}", key, lecture1Repository.LoadInfo(key));
    }

    @Override
    public void homework(String key) {
        log.info("Lecture1 과제 입니다. {}", lecture1Repository.LoadInfo(key));
    }

}
