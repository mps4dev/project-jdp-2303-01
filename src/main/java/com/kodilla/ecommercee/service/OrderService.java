package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void createOrderBasedOnCart(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        Cart cart = optionalCart.get();
        User user = optionalCart.get().getUser();
        Order order = new Order(null, cart, user);
        orderRepository.save(order);
    }

    public List<Order> showOrders() {
        return orderRepository.findAll();
    }

    public Order showOrder(final long orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(final long orderId) {
        orderRepository.deleteById(orderId);
    }
}
