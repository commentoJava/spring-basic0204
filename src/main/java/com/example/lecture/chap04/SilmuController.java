package com.example.lecture.chap04;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SilmuController {

    private final UnitService unitService;

    @GetMapping("/silmu/{name}")
    public String getUnitName(@PathVariable String name){
        return unitService.getUnitName(name);
    }
}
