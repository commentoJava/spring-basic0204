package com.example.lecture.chapter01.homework_sh;

public class main {

    public static void main(String[] args) {
        Lecture1ServiceImpl sv = new Lecture1ServiceImpl(new Lecture1RepositoryImpl());

        sv.insertByKey("1", "123");
        sv.homework("1");
    }

}
