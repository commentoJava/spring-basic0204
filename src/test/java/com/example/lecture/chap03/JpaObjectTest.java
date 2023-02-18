package com.example.lecture.chap03;

import com.example.lecture.chap03.domain.Company;
import com.example.lecture.chap03.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class JpaObjectTest {

    @PersistenceContext
    private EntityManager em;

    // beforeEach는 일부러 하지 않음. \
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

    @AfterEach
    void clear() {

        log.info("\n ======= MEMBER 조회 START ======");

        for (Member member : em.createQuery("select m from Member m", Member.class).getResultList()) {
            log.info("\n member id :{} , name : {} , age : {} , member.company : {}",
                     member.getId(),
                     member.getName(),
                     member.getAge(),
                     member.getCompany());
        }

        log.info("\n ======= MEMBER 조회 END ======");

        log.info("\n ======= COMPANY 조회 START ======");

        for (Company company : em.createQuery("select c from Company  c", Company.class).getResultList()) {
            log.info("company id :{}  name : {} , company.member:  {} ", company.getId(), company.getCompanyName(), company.getMembers());
        }

        log.info("\n ======= COMPANY 조회 END ======");

    }

    @Test
    @DisplayName("연관 관계를 맺은 관계에서 값을 설정할 때 이렇게 하면 안됩니다.")
    void mistake() {

        Member member = new Member();
        member.setName("saechim");
        em.persist(member);

        Company company = new Company();
        company.setCompanyName("commento");

        company.getMembers().add(member);

        em.persist(company);

    }

    @Test
    @DisplayName("연관 관계를 맺은 관계에서 값을 설정할 때 이렇게 해야합니다")
    void correct() {

        Member member = new Member();
        member.setName("saechim");
        em.persist(member);

        Company company = new Company();
        company.setCompanyName("commento");

        company.getMembers().add(member);
        member.setCompany(company);

        em.persist(company);

    }

    @Test
    @DisplayName("CASCADE 설정을 한다면 한번 persist로 엮여있는 객체들도 저장됨")
    public void cascade(){
        Member member = new Member();
        member.setName("saechim");

        Company company = new Company();
        company.setCompanyName("COMMENTO");

        member.setCompany(company);
        company.getMembers().add(member);

        em.persist(company);

    }


    @Test
    @DisplayName("멤버를 조회할 때 회사도 같이 조회를 해야하는지?")
    void retrieveMemberAndCompany_PROBLEM() {
        dataSetUp();

        Member findMember = em.find(Member.class, 1L);

        log.info("\n 회원 이름 = {}", findMember.getName());

        // 조회한 Member의 Company는 프록시객체이기 때문에 조회를 할때에 select 쿼리가 한번 더 나감
        log.info("\n 회원이 소속된 회사 이름 =  {}", findMember.getCompany().getCompanyName());
    }

    @Test
    @DisplayName("멤버를 조회할 때 회사도 같이 조회를 해야하는지?")
    void retrieveMemberAndCompany_SOLVE() {
        dataSetUp();

        Member findMember = em.createQuery("select m from Member m join fetch m.company where m.id = :id", Member.class)
                                  .setParameter("id",1L)
                                      .getSingleResult();

        log.info("\n 회원 이름 = {}", findMember.getName());

        // 페치 조인으로 가져왔기 때문에 프록시가 아닌 실제 객체라 접근 시 쿼리가 한번 더 나가지 않음
        log.info("\n 회원이 소속된 회사 이름 =  {}", findMember.getCompany().getCompanyName());
    }

    @Test
    @DisplayName("페이징 기능")
    void paging(){
        for(int i=1; i<=30; i++){
            Member member = new Member();
            member.setName("회원 " +i);
            member.setAge(i);
            em.persist(member);
        }
        em.flush();
        em.clear();

        List<Member> memberByPaging = em.createQuery("select m from Member m order by m.age asc", Member.class)
                                    .setFirstResult(2)
                                    .setMaxResults(10)
                                    .getResultList();

        for (Member member : memberByPaging) {
            log.info("\n memberName :{}  memberAge : {}",member.getName(), member.getAge());
        }
    }


}
