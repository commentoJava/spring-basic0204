package com.example.lecture.homework_3.repository;

import com.example.lecture.homework_3.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    void save(Member member);

    Optional<Member> findById(Long memberId);

    List<Member> findAll();
}
