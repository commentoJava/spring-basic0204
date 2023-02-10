package com.example.lecture.homework1_1;

import com.example.lecture.homework1_1.repository.Lecture1RepositoryImpl;
import com.example.lecture.homework1_1.service.Lecture1ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Homework1_1 {
    Lecture1ServiceImpl service = new Lecture1ServiceImpl(new Lecture1RepositoryImpl());

    @Test
    void homework1_1(){
        //데이터 저장
        service.save("1","dog");
        service.save("2","cat");

        //데이터 조회 - key가 존재할때
        String value = service.findByKey("1");
        log.info("{}", value);

        //데이터 조회 - key가 존재하지 않을때
        value = service.findByKey("0");
        log.info("{}", value);

        //homework
        service.homework("2");

    }
}
