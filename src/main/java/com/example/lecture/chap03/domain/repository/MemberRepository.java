package com.example.lecture.chap03.domain.repository;

import com.example.lecture.chap03.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Optional<Member> findById(Long memberId);

    List<Member> findByName(String name);

    List<Member> findByNameAndAgeGreaterThan(String name , int age);

    List<Member> findByNameIn(List<String> names);
}
