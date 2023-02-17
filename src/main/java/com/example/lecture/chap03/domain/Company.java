package com.example.lecture.chap03.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Company {


    private Long id;

    private String companyName;

    private List<Member> members = new ArrayList<>();

}
