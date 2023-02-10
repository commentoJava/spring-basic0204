package com.example.lecture.chapter01.homework2;

public class Main {

    public static void main(String[] args) {
        Lecture1RepositorySpringImpl lecture1Repository = new Lecture1RepositorySpringImpl();
        Lecture1ServiceSpringImpl lecture1Service = new Lecture1ServiceSpringImpl(lecture1Repository);

        lecture1Service.saveData("name", "youjeong");
        lecture1Service.findData("name");
        lecture1Service.findData("hi");

        lecture1Service.homework("name");


    }
}
