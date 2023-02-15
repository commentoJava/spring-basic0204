package com.example.lecture.homework02.repository;

import com.example.lecture.homework02.domain.User;

import java.util.List;

public interface UserRepository {


    void save(User user);

    User findById(Long id);

    List<User> findAll();

    void update(Long id, User user);

    void delete(Long id);


}
