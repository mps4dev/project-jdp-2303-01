package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CartDTO {
    private Long cartId;
    private List<Product>products;
    private User user;
}
