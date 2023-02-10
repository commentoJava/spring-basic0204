package com.example.lecture.chapter01.homework1;

public class Main {

    public static void main(String[] args) {
        Lecture1RepositoryImpl lecture1Repository = new Lecture1RepositoryImpl();
        Lecture1ServiceImpl lecture1Service = new Lecture1ServiceImpl(lecture1Repository);

        lecture1Service.saveData("name", "youjeong");
        lecture1Service.findData("name");
        lecture1Service.findData("hi");

        lecture1Service.homework("name");


    }
}
