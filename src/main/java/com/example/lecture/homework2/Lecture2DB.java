package com.example.lecture.homework2;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Lecture2DB {
    Long id = 0L;
    Map<Long, User> userMap = new ConcurrentHashMap<>();

    public User get(Long id) {
        return userMap.get(id);
    }

    public User put(User user) {
        return userMap.put(id++, user);
    }

    public User put(Long id, User user) {
        return userMap.put(id, user);
    }

    public void delete(Long id){
        userMap.remove(id);
    }
}
