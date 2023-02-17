package com.example.lecture.homework2.repository;

import com.example.lecture.homework2.Lecture2DB;
import com.example.lecture.homework2.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final Lecture2DB lecture2DB;

    public UserRepositoryImpl(Lecture2DB lecture2DB) {
        this.lecture2DB = lecture2DB;
    }

    @Override
    public User findUserById(Long id) {
        return lecture2DB.get(id);
    }

    @Override
    public User registerUser(User user) {
        return lecture2DB.put(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return lecture2DB.put(id, user);
    }

    @Override
    public void deleteUser(Long id) { lecture2DB.delete(id); }
}
