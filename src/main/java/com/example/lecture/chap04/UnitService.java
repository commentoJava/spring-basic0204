package com.example.lecture.chap04;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UnitService {

    // 전략 패턴
    private final UnitFactory unitFactory;

    public String getUnitName(String unitName) {
        UnitEnum unitEnum = UnitEnum.getUnitEnumByStringType(unitName);
        Unit unit = Optional.ofNullable(unitFactory.findUnit(unitEnum)).orElseThrow(() -> new RuntimeException("에러입니다"));
        return unit.whatUnit();
    }
}
