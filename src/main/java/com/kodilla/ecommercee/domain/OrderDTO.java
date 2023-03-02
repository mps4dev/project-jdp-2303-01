package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.SimpleDateFormat;

@Getter
@AllArgsConstructor
public class OrderDTO {
    private Long orderId;
    private Long productId;
    private double productAmount;
    private SimpleDateFormat orderDate;
    private SimpleDateFormat deliveryDate;
    private String address;
}
