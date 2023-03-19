package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
public class Product {
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
    @JsonIgnore
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    @JsonBackReference
    private List<Cart> carts;

    public Product(Long productId, String name, double price, int quantity, Group group) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.group = group;
    }
}
