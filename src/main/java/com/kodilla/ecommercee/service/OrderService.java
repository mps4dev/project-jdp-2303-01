package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public List<Order> showOrders() {
        return orderRepository.findAll();
    }

    public Order showOrder(final long orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }
    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(final long orderId) throws  OrderNotFoundException{
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()){
        orderRepository.deleteById(orderId);
        }else {
            System.out.println("Order with  Id " + orderId+ " not found" );
            throw new OrderNotFoundException();
        }
    }

    public void createOrderBasedOnCart(Long cartId) throws CartNotFoundException {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()){
        Cart cart = optionalCart.get();
        User user = optionalCart.get().getUser();
        Order order = new Order(null, cart, user);
        orderRepository.save(order);
        }else {
            System.out.println("Cart with  Id " + cartId+ " not found" );
            throw new CartNotFoundException();
        }
    }
}

