package com.example.lecture.chap04;

import org.springframework.stereotype.Service;

@Service
public class Genie implements Unit {

    @Override
    public String whatUnit() {
        return "GENIE 비즈니스";
    }

    @Override
    public UnitEnum getUnitName() {
        return UnitEnum.GENIE;
    }
}
