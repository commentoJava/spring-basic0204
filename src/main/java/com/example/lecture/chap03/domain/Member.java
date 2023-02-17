package com.example.lecture.chap03.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;

    private String name;

    private int age;

    private Company company;

}