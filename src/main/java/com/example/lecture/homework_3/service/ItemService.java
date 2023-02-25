package com.example.lecture.homework_3.service;

import com.example.lecture.homework_3.domain.Item;
import com.example.lecture.homework_3.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    public Item findItemOne(Long itemId) {
        return itemRepository.findById(itemId).get();
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }
}
