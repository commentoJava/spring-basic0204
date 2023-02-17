package com.example.lecture.homework1_2;

import com.example.lecture.homework1_2.service.Lecture1ServiceWithSpring;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Homework1_2 {
    @Autowired
    Lecture1ServiceWithSpring lecture1ServiceWithSpring;

    @Test
    void homework1_2(){
        lecture1ServiceWithSpring.save("1","dog");
        lecture1ServiceWithSpring.save("2","cat");

        String value = lecture1ServiceWithSpring.findByKey("1");
        log.info("{}",value);

        value = lecture1ServiceWithSpring.findByKey("0");
        log.info("{}",value);

        lecture1ServiceWithSpring.homework("1");

    }
}
