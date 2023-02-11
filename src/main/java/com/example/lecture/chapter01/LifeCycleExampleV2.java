package com.example.lecture.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Slf4j
public class LifeCycleExampleV2 {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ExampleClass exampleClass(){
        return new ExampleClass();
    }
}


@Slf4j
class ExampleClass {
    public void init() {
        log.info("\n 초기화 콜백 v2");
    }

    public void destroy(){
        log.info("\n 소멸전 콜백 v2");
    }
}