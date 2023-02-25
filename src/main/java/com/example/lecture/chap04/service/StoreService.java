package com.example.lecture.chap04.service;

import com.example.lecture.chap04.domain.Store;
import com.example.lecture.chap04.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    public List<Store> findAllStoreByName(String name) {
        return storeRepository.findAllByStore(name);
    }
}
