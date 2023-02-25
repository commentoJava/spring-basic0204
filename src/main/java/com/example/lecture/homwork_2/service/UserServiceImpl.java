package com.example.lecture.homwork_2.service;

import com.example.lecture.homwork_2.doamain.User;
import com.example.lecture.homwork_2.repository.UserRepository;
import com.example.lecture.homwork_2.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> login(Long userId) {
        //중복체크 로직 추가하기
        return userRepository.findByUserId(userId);
    }

    @Override
    public User join(User user) {
        return userRepository.save(user);
    }

    @Override
    public void withdrawal(Long userId) {
        userRepository.deleteUser(userId);
    }

    @Override
    public void modify(Long userId, User updateUser) {
        userRepository.updateUser(userId, updateUser);
    }
}
