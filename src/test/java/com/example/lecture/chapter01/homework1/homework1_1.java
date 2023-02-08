package com.example.lecture.chapter01.homework1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class homework1_1 {

    @Test
    void homework1_1() {
        Lecture1RepositoryImpl repository = new Lecture1RepositoryImpl();
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key1", "val1");
        map.put("key2", "val2");
        repository.save(map);

        Lecture1ServiceImpl service = new Lecture1ServiceImpl();

        //데이터 존재시
        service.homework("key1");

        //데이터 존재하지 않을시
        service.homework("test");


        noSpringSingletonDB instance1 = noSpringSingletonDB.getInstance();
        noSpringSingletonDB instance2 = noSpringSingletonDB.getInstance();

        log.info("싱글톤 ?? ={}" , instance1 == instance2);

    }
}
