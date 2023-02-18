package com.example.lecture.chap03.domain.repository;

import com.example.lecture.chap03.domain.Company;
import com.example.lecture.chap03.domain.Member;
import com.example.lecture.chap03.domain.dto.MemberCompanyDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class MemberSpringDataRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberSpringDataRepository memberSpringDataRepository;

    void dataSetUp() {

        Member member = new Member();
        member.setName("saechim");
        em.persist(member);

        Company company = new Company();
        company.setCompanyName("commento");

        company.getMembers().add(member);
        member.setCompany(company);

        em.persist(company);
        em.flush();
        em.clear();
    }

    @BeforeEach
    void setUp(){
        for(int i=1; i<=30; i++){
            Member member = new Member();
            member.setName("회원 " +i);
            member.setAge(i);
            memberSpringDataRepository.save(member);
        }
        em.flush();
        em.clear();
    }

    @Test
    @DisplayName("회원을 이름으로 찾기")
    void findName(){
        List<Member> byName = memberSpringDataRepository.findByName("회원 7");
        log.info("\n byName = {} ",byName);
    }

    @Test
    @DisplayName("이름이 같으면서 나이가 이것보단 큰")
    void findNameAge(){
        List<Member> byNameAndAgeGreaterThan = memberSpringDataRepository.findByNameAndAgeGreaterThan("회원 7", 3);
        log.info("\n 멤버 = {}",byNameAndAgeGreaterThan);

        List<Member> customName = memberSpringDataRepository.findCustomName("회원 7", 3);
        log.info("\n 멤버 = {}",customName);

    }

    @Test
    @DisplayName("DTO로 조회")
    void findDto(){
        dataSetUp();
        List<MemberCompanyDto> dto = memberSpringDataRepository.findDto();

        for (MemberCompanyDto memberCompanyDto : dto) {
            log.info("\n memberName : {} companyName : {} ",memberCompanyDto.getMemberName() , memberCompanyDto.getCompanyName());
        }
    }


    @Test
    @DisplayName("이름 in절 조회")
    void findByNames(){
        List<Member> 회원 = memberSpringDataRepository.findByNameIn(List.of("회원 1", "회원 2"));
        for (Member member : 회원) {
            log.info("\n member = {}" ,member);
        }
    }

    @Test
    @DisplayName("이름 like")
    void findLikeName(){
        List<Member> 회원_ = memberSpringDataRepository.findByNameLike("%회원%");
        for (Member member : 회원_) {
            log.info("\n member = {}" ,member);
        }
    }


}