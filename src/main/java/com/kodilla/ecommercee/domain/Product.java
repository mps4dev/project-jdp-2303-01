package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product extends Auditable {
    @Id
    @GeneratedValue
    private Long productId;

    @Column(unique = true)
    private String name;

    private double price;

    private int quantity;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts;

    public Product(Long productId, String name, double price, int quantity, Group group) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.group = group;
    }
}

