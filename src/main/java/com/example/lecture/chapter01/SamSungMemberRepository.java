package com.example.lecture.chapter01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SamSungMemberRepository implements MemberRepository{
    @Override
    public void findById(Long id) {
        log.info("\n SamSungMemberRepository {} 를 호출",id);
    }
}
