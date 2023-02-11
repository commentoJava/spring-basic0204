package com.example.lecture.chapter01;

/**
 * 그룹사 회원 전체가 담긴 DB를 조회하는 기능 제공.
 */
public interface MemberRepository {

    void findById(Long id);
}
