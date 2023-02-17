package com.example.lecture.homework2.service;

import com.example.lecture.homework2.User;
import com.example.lecture.homework2.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User registerUser(User user) {
        return userRepository.registerUser(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.updateUser(id, user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
