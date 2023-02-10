package com.example.lecture.chapter01.homework1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class Lecture1ServiceImpl implements Lecture1ServiceNoSpring {

    private final Lecture1RepositoryImpl lecture1Repository;

    public Lecture1ServiceImpl(Lecture1RepositoryImpl lecture1Repository) {
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
