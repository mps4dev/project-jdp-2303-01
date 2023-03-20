package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserDTO {
    private Long userId;
    private String name;
    private String lastName;
    private String address;
    private String login;
    private String password;
    private boolean isBlocked;
    private Cart cart;
    private List<Order> orders = new ArrayList<>();
    public UserDTO(Long userId, String name, String lastName, String address, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.login = login;
        this.password = password;
        this.isBlocked = false;
    }
}
