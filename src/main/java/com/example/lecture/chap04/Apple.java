package com.example.lecture.chap04;

import org.springframework.stereotype.Service;

@Service
public class Apple implements Unit{

    @Override
    public String whatUnit() {
        return "Apple 비즈니스";
    }

    @Override
    public UnitEnum getUnitName() {
        return UnitEnum.APPLE;
    }
}
