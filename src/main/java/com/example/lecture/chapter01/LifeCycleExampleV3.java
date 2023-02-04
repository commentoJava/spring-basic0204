package com.example.lecture.chapter01;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LifeCycleExampleV3 {

    @PostConstruct
    public void init(){
        log.info("\n 초기화 콜백 v3");
    }

    @PreDestroy
    public void destroy(){
        log.info("\n 소멸전 콜백 v3");
    }
}
