package com.example.lecture.chap04.repository;

import com.example.lecture.chap04.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {

    List<Store> findAllByStore(String storeName);
}




