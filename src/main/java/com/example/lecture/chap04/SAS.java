package com.example.lecture.chap04;

import org.springframework.stereotype.Service;

@Service
public class SAS implements Unit {
    @Override
    public String whatUnit() {
        return "SAS 비즈니스 로직";
    }

    @Override
    public UnitEnum getUnitName() {
        return UnitEnum.SAS;
    }
}
