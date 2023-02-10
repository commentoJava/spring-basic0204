package com.example.lecture.chapter01.homework2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Lecture1RepositorySpringImpl implements Lecture1RepositoryWithSpring {
    private Map<String, String> repo = new HashMap<String, String>();
    private static volatile Lecture1RepositorySpringImpl instance;

    public static class SingletonHolder {
        private static final Lecture1RepositoryWithSpring LECTURE_1_REPOSITORY_WITH_SPRING = new Lecture1RepositorySpringImpl();
    }

    Lecture1RepositorySpringImpl(){};

    public static Lecture1RepositoryWithSpring getInstance() {
        return SingletonHolder.LECTURE_1_REPOSITORY_WITH_SPRING;
    }
    @Override
    public String LoadInfo(String key) {
        if (repo.get(key) != null) {
//            log.info("===Repository LoadInfo==={}", key);
            return repo.get(key);
        } else {
            return "Commento";
        }



    }

    @Override
    public void SaveInfo(String key,String value) {
//        log.info("===Repository SaveInfo===");
        repo.put(key,value);
    }


}
