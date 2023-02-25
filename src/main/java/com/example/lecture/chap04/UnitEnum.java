package com.example.lecture.chap04;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum UnitEnum {

    APPLE("apple"), GENIE("genie"), SAS("sas");

    private final String unitName;

    UnitEnum(String unitName) {
        this.unitName = unitName;
    }

    private static final Map<String, UnitEnum> unitEnumMap = new HashMap<>();
//        Collections.unmodifiableMap(Stream.of(values())
//                                          .collect(Collectors.toMap(UnitEnum::getUnitName,
//                                                                    Function.identity())));

    static {
        Arrays.stream(values()).forEachOrdered(unit -> unitEnumMap.put(unit.getUnitName(), unit));
    }

    public static UnitEnum getUnitEnumByStringType(String unitName) {
        return unitEnumMap.get(unitName);
    }
}
