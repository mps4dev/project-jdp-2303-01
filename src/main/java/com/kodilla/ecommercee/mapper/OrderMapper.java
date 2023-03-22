package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order mapToOrder(OrderDTO orderDTO) {
        return new Order(orderDTO.getOrderId(),
                orderDTO.getCart(),
                orderDTO.getUser());
    }
}
