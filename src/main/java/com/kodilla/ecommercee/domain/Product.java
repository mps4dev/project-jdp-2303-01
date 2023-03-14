package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long productId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "group_id")
    private Group group;

    public Product(String name, double price, int quantity, Group group) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.group = group;
    }
}
