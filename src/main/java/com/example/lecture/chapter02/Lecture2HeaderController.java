package com.example.lecture.chapter02;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lec2/header")
public class Lecture2HeaderController {


    // localhost:8080/lec2/header/v1

    @GetMapping("/v1")
    public ResponseEntity<String> responseEntityV1(HttpServletResponse response){

        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("name", "saechim");
        multiValueMap.add("company","samsung");
        multiValueMap.add("company","commento");

        response.addHeader("jwt", "13124124123523513ffadsf");

        return new ResponseEntity<>("ok",multiValueMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
