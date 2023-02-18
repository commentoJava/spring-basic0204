package com.example.lecture.chap03.homework3_2.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;

    private String zipcode;

    private String street;

    private String telephone;
}
