package com.example.lecture.homwork_2.repository;

import com.example.lecture.homwork_2.doamain.User;

import java.util.Optional;

public interface UserRepository {

    //조회 삭제 수정 추가

    Optional<User> findByUserId(Long userId); //사용자 아이디로 조회

    Optional<User> findByUserName(String userName); //사용자 이름으로 조회

    User save(User user); //사용자 저장

    void deleteUser(Long userId); //사용자 삭제

    void updateUser(Long userId, User updateUser); //사용자 정보 수정


}
