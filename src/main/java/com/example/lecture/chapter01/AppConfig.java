package com.example.lecture.chapter01;

import com.example.lecture.chapter01.homework_sh.Lecture1RepositoryImpl;
import com.example.lecture.chapter01.homework_sh.Lecture1RepositorySpringImpl;
import com.example.lecture.chapter01.homework_sh.Lecture1RepositoryWithSpring;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = "prototype")
    @ConditionalOnMissingBean
    public MemberService samSungElecMemberSerivce() {
        return new SamSungElecMemberService(memberRepository());
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean
    public MemberService samSungSdsMemberService() {
        return new SamSungSdsMemberService(memberRepository());
    }


    @Bean
    @ConditionalOnMissingBean
    public MemberRepository memberRepository() {
        return new SamSungMemberRepository();
    }


    @Bean
    @ConditionalOnMissingBean
    public Lecture1RepositoryWithSpring Lecture1RepositoryWithSpring() {
        return new Lecture1RepositorySpringImpl();
    }


}

