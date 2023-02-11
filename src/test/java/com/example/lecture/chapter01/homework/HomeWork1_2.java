package com.example.lecture.chapter01.homework;


import com.example.lecture.chapter01.homework_sh.Lecture1ServiceWithSpring;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HomeWork1_2 {


    @Autowired
    Lecture1ServiceWithSpring lc1Spring;


    @Test
    void homework1_2() {
        lc1Spring.homework2("12");
    }



}
