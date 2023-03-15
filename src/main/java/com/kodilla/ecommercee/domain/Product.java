package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(unique = true)
    private String name;

    private double price;

     private int quantity;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "group_id")
    private Group group;
}
