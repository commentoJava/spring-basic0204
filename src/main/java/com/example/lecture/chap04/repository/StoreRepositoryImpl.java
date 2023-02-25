package com.example.lecture.chap04.repository;

import com.example.lecture.chap04.domain.QStore;
import com.example.lecture.chap04.domain.Store;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import static com.example.lecture.chap04.domain.QStore.*;

public class StoreRepositoryImpl implements StoreRepositoryCustom{


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Store> findAllByStore(String storeName) {

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        return jpaQueryFactory.selectFrom(store)
            .where(store.storeName.eq(storeName))
            .fetch();

    }
}
