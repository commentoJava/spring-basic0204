package com.example.lecture.chapter01.homework;

import com.example.lecture.chapter01.homework_sh.Lecture1RepositoryImpl;
import com.example.lecture.chapter01.homework_sh.Lecture1ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


public class HomeWork1_1 {


    public static class test_noSpring {

    //    public static void main(String[] args) {
    //        Lecture1ServiceImpl sv = new Lecture1ServiceImpl(new Lecture1RepositoryImpl());
    //
    //        sv.insertByKey("2", "123");
    //        sv.homework("2");
    //    }

        Lecture1ServiceImpl sv = new Lecture1ServiceImpl(new Lecture1RepositoryImpl());

        @Test
        void aTest() {
            sv.insertByKey("2", "123");
            sv.homework("2");
        }

    }
}
