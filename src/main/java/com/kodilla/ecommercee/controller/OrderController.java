package com.kodilla.ecommercee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kodilla.ecommercee.dto.OrderDTO;

import java.util.*;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() { return ResponseEntity.ok(Collections.emptyList()); }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long orderId) { return ResponseEntity.ok(null); }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) { return ResponseEntity.ok(null); }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(null);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok().build();
    }
}
