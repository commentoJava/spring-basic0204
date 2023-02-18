package com.example.lecture.chap03.homework3_2.domain.type;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ING("주문 요청"), END("주문 완료");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }
}
