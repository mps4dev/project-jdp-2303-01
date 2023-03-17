package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GroupDTO {
    private Long groupId;
    private String name;
    List<Product> products = new ArrayList<>();
    public GroupDTO(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
