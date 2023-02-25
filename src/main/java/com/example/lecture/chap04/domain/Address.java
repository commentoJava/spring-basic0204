package com.example.lecture.chap04.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;

    private String zipCode;

    private String street;
}