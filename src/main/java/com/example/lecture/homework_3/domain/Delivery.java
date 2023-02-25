package com.example.lecture.homework_3.domain;

import jakarta.persistence.*;

public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated
    private DeliveryStatus deliveryStatus;

    private Delivery delivery;
}
