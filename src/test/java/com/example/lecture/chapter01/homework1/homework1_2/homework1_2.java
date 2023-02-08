package com.example.lecture.chapter01.homework1.homework1_2;

import com.example.lecture.chapter01.homework1.Lecture1RepositoryNoSpring;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class homework1_2 {

    @Autowired
    Lecture1ServiceWithSpring  Lecture1ServiceWithSpring;

    @Autowired
    SpringSingletonDB springSingletonDB;

    @Test
    void homework1_2() {

        HashMap<String, String> map = new HashMap<>();
        map.put("spring1", "springVal1");
        map.put("spring2", "springVal2");

        springSingletonDB.setSpringData(map);


        //
        Lecture1ServiceWithSpring.homwork("spring1");

        Lecture1ServiceWithSpring.homwork("not");
    }

}