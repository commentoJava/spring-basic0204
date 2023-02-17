package com.example.lecture.homework2.repository;

import com.example.lecture.homework2.User;

public interface UserRepository {
    User findUserById(Long id);
    User registerUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

}
