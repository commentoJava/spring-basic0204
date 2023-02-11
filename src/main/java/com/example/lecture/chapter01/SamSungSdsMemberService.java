package com.example.lecture.chapter01;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class SamSungSdsMemberService implements MemberService{
    private final MemberRepository memberRepository;

    @Value("${secret.value}")
    private String value;

    @Override
    public void findMember(Long id) {
        log.info("\n ==== 삼성sds {}=== ",value);
        memberRepository.findById(id);
    }
}
