package com.example.lecture.chap04.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String productName;

    private int price;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @ToString.Exclude
    private Store store;

    public Product(int price, int quantity) {
        this(null, price, quantity, null);
    }

    public Product(String productName, int price, int quantity) {
        this(productName, price, quantity, null);
    }

    public Product(String productName, int price, int quantity, Store store) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        if (store != null) {
            changeStore(store);
        }
    }

    public void changeStore(Store store) {
        this.store = store;
        store.getProducts().add(this);
    }
}