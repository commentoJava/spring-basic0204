package com.example.lecture.chapter01.homework2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AppConfig.class)
public class SpringTest {
    @Autowired
    Lecture1ServiceWithSpring lecture1Service;


    @Test
    void springTest(){
        lecture1Service.saveData("name", "choi");
        lecture1Service.findData("name");
    }
}
