package com.example.lecture.homework_3.domain;

import jakarta.persistence.*;

import java.util.List;

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Item> items;

}
