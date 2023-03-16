package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "orders")
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
    private LocalDateTime orderDate;

    @Column(name = "orderPaymentDate")
    private LocalDateTime orderPaymentDate;

    @Column(name = "orderValue")
    private int orderValue;

    @Column(name = "orderAmountPaid")
    private int orderAmountPaid;

    public Order(LocalDateTime orderDate, LocalDateTime orderPaymentDate, int orderValue, int orderAmountPaid) {
        this.carts = carts;
        this.orderDate = ZonedDateTime.now().toLocalDateTime();
        this.orderPaymentDate = orderPaymentDate;
        this.orderValue = orderValue;
        this.orderAmountPaid = orderAmountPaid;
    }
}