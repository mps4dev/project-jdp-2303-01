package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDTO;

import com.kodilla.ecommercee.exception.OrderNotFoundException;

import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("v1/orders")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable long orderId) {
        List<Order> orderList = orderService.showOrders();
        return ResponseEntity.ok(orderMapper.mapToOrderDTOList(orderList));
    }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable long orderId) throws OrderNotFoundException {
        Order foundOrder = orderService.showOrder(orderId);
        return ResponseEntity.ok(orderMapper.mapToOrderDTO(foundOrder));
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId) {
        return ResponseEntity.ok(null);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.mapToOrder(orderDTO);
        Order updatedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(orderMapper.mapToOrderDTO(updatedOrder));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.mapToOrder(orderDTO);
        orderService.saveOrder(order);
        return ResponseEntity.ok().build();
    }
}
