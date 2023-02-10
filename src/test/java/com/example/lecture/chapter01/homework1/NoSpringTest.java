package com.example.lecture.chapter01.homework1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
public class NoSpringTest {
    @Test
    void noSpringTest() {
        Lecture1RepositoryImpl lecture1Repository = new Lecture1RepositoryImpl();
        Lecture1ServiceImpl lecture1Service = new Lecture1ServiceImpl(lecture1Repository);

        lecture1Service.saveData("name", "youjeong");
        lecture1Service.findData("name");
        lecture1Service.findData("hi");

        lecture1Service.homework("name");
    }
}
