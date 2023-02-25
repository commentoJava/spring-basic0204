package com.example.lecture.homework_3.repository;

import com.example.lecture.homework_3.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository{

    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.of(em.find(Member.class, memberId));
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from member m", Member.class).getResultList();
    }
}
