package com.example.lecture.chapter01;

import com.example.lecture.chapter01.homework1.homework1_2.*;
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
    public MemberRepository memberRepository(){
        return new SamSungMemberRepository();
    }

    @Bean
    public Lecture1ServiceWithSpring Lecture1ServiceWithSpring() {
        return new Lecture1ServiceSpringImpl(lecture1RepositoryWithSpring());
    }

    @Bean
    public Lecture1RepositoryWithSpring lecture1RepositoryWithSpring() {
        return new Lecture1RepositorySringImpl(springSingletonDB());
    }

    @Bean
    public SpringSingletonDB springSingletonDB() {
        return new SpringSingletonDB();
    }
}
