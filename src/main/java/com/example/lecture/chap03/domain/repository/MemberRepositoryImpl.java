package com.example.lecture.chap03.domain.repository;

import com.example.lecture.chap03.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepositoryImpl implements MemberRepository{


    // @Autowired가 스프링의 빈을 주입, PersistenceContext JPA 스펙에서 제공하는 기능, 영속성 컨텍스를 주입하는 표준 애노테이션이다.
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        Member member = em.find(Member.class, memberId);
        return Optional.of(member);
    }

    @Override
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name")
                 .setParameter("name", name)
                 .getResultList();
    }

    @Override
    // 이름이 같으면서 나이가 이것보다 큰
    public List<Member> findByNameAndAgeGreaterThan(String name, int age) {

         // findByNameAndAgeGreaterThan
        return em.createQuery("select m from Member m where m.name = :name and m.age > :age")
            .setParameter("name",name)
            .setParameter("age",age)
            .getResultList();
    }

    @Override
    public List<Member> findByNameIn(List<String> names) {
        return em.createQuery("select m from Member m where m.name in :names")
            .setParameter("names",names)
            .getResultList();
    }
}
