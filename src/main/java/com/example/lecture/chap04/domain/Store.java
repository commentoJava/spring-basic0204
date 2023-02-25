package com.example.lecture.chap04.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String storeName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    public Store(String storeName) {
        this(storeName, null);
    }

    public Store(String storeName, Address address) {
        this.storeName = storeName;
        this.address = address;
    }

    public void changeProducts(Product product) {
        this.products.add(product);
        product.setStore(this);
    }

    public void changeProducts(List<Product> products) {
        this.products.addAll(products);
        products.forEach(product -> product.setStore(this));
    }
}