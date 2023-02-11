package com.example.lecture.chapter02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lec2/model")
@Slf4j
public class Lecture2ModelController {



    // localhost:8080/lec2/model/v1?name=apple&price=3000

    @GetMapping("/v1")
    public String modelV1(@ModelAttribute Fruit fruit) {
        log.info("\n Fruit 정보 {}",fruit.toString());
        return "fruit name = " + fruit.getName() + " fruit price = " +fruit.getPrice();
    }

    @PostMapping("/v1")
    public ResponseEntity<?> postFruitV1(@RequestBody Fruit fruit) {
        log.info("\n Fruit 정보 {}",fruit.toString());

        if(fruit.getPrice() < 1000){
            return ResponseEntity.badRequest()
                                 .body("fruit name = " + fruit.getName() + " fruit price = " +fruit.getPrice());
        }else{
            return ResponseEntity.ok()
                                 .body("fruit name = " + fruit.getName() + " fruit price = " +fruit.getPrice());
        }
    }


    @Getter
    @AllArgsConstructor
    @ToString
    static class Fruit{
        private String name;
        private int price;
    }
}
