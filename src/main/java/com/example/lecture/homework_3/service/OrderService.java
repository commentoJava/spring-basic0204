package com.example.lecture.homework_3.service;

import com.example.lecture.homework_3.domain.Item;
import com.example.lecture.homework_3.domain.Member;
import com.example.lecture.homework_3.domain.Order;
import com.example.lecture.homework_3.repository.ItemRepository;
import com.example.lecture.homework_3.repository.MemberRepository;
import com.example.lecture.homework_3.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private MemberRepository memberRepository;
    private ItemRepository itemRepository;
    private OrderRepository orderRepository;

    @Transactional
    public Long order(Long memberId, Long itemId) {

        Member member = memberRepository.findById(memberId).get();
        Item item = itemRepository.findById(itemId).get();

        Order order = Order.createOrder(member, item);
        return order.getId(); //배송넣어야함..


    }
}
