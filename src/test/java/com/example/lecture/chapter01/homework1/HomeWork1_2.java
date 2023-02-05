package com.example.lecture.chapter01.homework1;
import com.example.lecture.chapter01.homework1.service.Lecture1ServiceWithSpring;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HomeWork1_2 {

    @Autowired
    Lecture1ServiceWithSpring lecture1ServiceWithSpring;

    @Test
    void homework1_2() {
        lecture1ServiceWithSpring.save("박병호","박병호");
        lecture1ServiceWithSpring.homework("박병호");
    }


}
