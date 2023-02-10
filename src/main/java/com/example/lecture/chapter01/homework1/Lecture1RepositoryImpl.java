package com.example.lecture.chapter01.homework1;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Lecture1RepositoryImpl implements Lecture1RepositoryNoSpring{
    private Map<String, String> repo = new HashMap<String, String>();
    private static volatile Lecture1RepositoryImpl instance;

    public static class SingletonHolder {
        private static final Lecture1RepositoryNoSpring lecture1RepositoryNoSpring = new Lecture1RepositoryImpl();
    }

    // 외부에서 생성자 호출 막기
    Lecture1RepositoryImpl(){};

    public static Lecture1RepositoryNoSpring getInstance() {
        return SingletonHolder.lecture1RepositoryNoSpring;
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
