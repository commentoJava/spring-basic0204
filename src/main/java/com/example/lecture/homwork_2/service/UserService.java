package com.example.lecture.homwork_2.service;

import com.example.lecture.homwork_2.doamain.User;

import java.util.Optional;

public interface UserService {

    //로그인?
    Optional<User> login(Long userId);

    //회원가입?
    User join(User user);

    //탈퇴
    void withdrawal(Long userId);

    //회원정보 수정
    void modify(Long userId, User updateUser);

}
