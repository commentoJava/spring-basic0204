package com.example.lecture.chapter01.homework2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Lecture1ServiceWithSpring lecture1ServiceSpring(){
        return new Lecture1ServiceSpringImpl((Lecture1RepositorySpringImpl) lecture1Repository());
    }

    @Bean
    public Lecture1RepositoryWithSpring lecture1Repository() {
        return new Lecture1RepositorySpringImpl();
    }
}
