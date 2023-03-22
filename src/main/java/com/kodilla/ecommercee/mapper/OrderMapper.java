package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    public Order mapToOrder(final OrderDTO orderDTO) {
        return new Order(orderDTO.getOrderId(),
                orderDTO.getCart(),
                orderDTO.getUser(),
                orderDTO.getOrderDate());
    }

    public OrderDTO mapToOrderDTO(final Order order) {
        return new OrderDTO(order.getOrderId(),
                order.getCart(),
                order.getUser(),
                order.getOrderDate());
    }

    public List<OrderDTO> mapToOrderDTOList(List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDTO)
                .collect(Collectors.toList());
    }
}
