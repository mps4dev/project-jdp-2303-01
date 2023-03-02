package com.kodilla.ecommercee.domain.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CartDTO {
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "cartId")
    private Long cartId;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "productId")
    private List<Product>products;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "userId")
    private User user;

}
