package com.example.lecture.chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class UnitFactory {

    private Map<UnitEnum, Unit> unitMap;

    @Autowired
    public UnitFactory(Set<Unit> unitSet) {
        creatUnit(unitSet);
    }

    public Unit findUnit(UnitEnum unitEnum) {
        return unitMap.get(unitEnum);
    }

    private void creatUnit(Set<Unit> unitSet){
        unitMap = new HashMap<>();
        unitSet.forEach(m -> unitMap.put(m.getUnitName(), m));
    }
}
