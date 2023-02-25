package com.example.lecture.homework_3.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @OneToMany(mappedBy = "order" ,cascade = CascadeType.ALL)
    private List<Item> items;

    private LocalDateTime ordersDate;

    @Enumerated
    private OrderStatus orderStatus;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Delivery delivery;


    public static  Order createOrder(Member member, Item item) {
        Order order = new Order();
        order.setMember(member);
        order.setOrderStatus(OrderStatus.ORDER);
        order.setOrdersDate(LocalDateTime.now());

        return order;
    }
}
