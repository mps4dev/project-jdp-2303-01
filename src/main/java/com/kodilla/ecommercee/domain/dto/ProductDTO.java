package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Group;
import lombok.Getter;

@Getter
public class ProductDTO {
    private Long productId;
    private String name;
    private double price;
    private int quantity;
    private Group group;

    public ProductDTO(String name, double price, int quantity, Group group) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.group = group;
    }
}
