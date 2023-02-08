package com.example.lecture.chapter01;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class SamSungElecMemberService implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void findMember(Long id) {
        log.info("\n ==== 삼성전자 ===");
        memberRepository.findById(id);
    }
}
