package com.example.lecture.chapter01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
//@ActiveProfiles("prod")
public class SamsungTest {

    @Autowired
    SamSungSdsMemberService memberService;

    @Test
    void abcdTest() {
        memberService.findMember(1L);
    }
}
