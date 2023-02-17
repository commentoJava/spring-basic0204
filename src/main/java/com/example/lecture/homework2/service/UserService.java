package com.example.lecture.homework2.service;

import com.example.lecture.homework2.User;

public interface UserService {
    User findUserById(Long id);
    User registerUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
