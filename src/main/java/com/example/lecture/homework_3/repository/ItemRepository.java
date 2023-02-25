package com.example.lecture.homework_3.repository;

import com.example.lecture.homework_3.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Item item) {
        em.persist(item);
    }

    public Optional<Item> findById(Long itemId) {
        return Optional.of(em.find(Item.class, itemId));
    }

    public List<Item> findAll() {
        return em.createQuery("select i from item i", Item.class)
                .getResultList();
    }
}
