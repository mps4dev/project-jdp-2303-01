package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_orders_carts",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "cart_id")})
    private List<Cart> carts = new ArrayList<>();

    @Column(name = "orderDate")
    private SimpleDateFormat orderDate;

    @Column(name = "orderPaymentDate")
    private SimpleDateFormat orderPaymentDate;

    @Column(name = "orderValue")
    private int orderValue;

    @Column(name = "orderAmountPaid")
    private int orderAmountPaid;


}