package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {
    @Autowired
    private OrderRepository orderRepository;
    private User user;
    private User user2;
    private Cart cart;
    private Cart cart2;
    private Order order1;
    private Order order2;

    public void prepareDataTests() {
        user = new User(null, "name", "lastName", "address", "login", "password");
        user2 = new User(null, "name", "lastName", "address", "login", "password");
        cart = new Cart(null, new ArrayList<>(), user);
        cart2 = new Cart(null, new ArrayList<>(), user2);
        order1 = new Order(null, cart, user);
        order2 = new Order(null, cart2, user2);

    }

    @Test
    public void shouldFindAllOrders() {
        //Given
        prepareDataTests();

        //When
        Order savedOrder1 = orderRepository.save(order1);
        Order savedOrder2 = orderRepository.save(order2);
        List<Order> foundOrders = orderRepository.findAll();

        //Then
        assertEquals(2, foundOrders.size());

        //CleanUp
        orderRepository.deleteAll();
    }

    @Test
    public void testFindById() {
        //Given
        Order order2 = orderRepository.save(new Order(null, cart, user));

        //When
        Optional<Order> optionalOrder2 = orderRepository.findById(order2.getOrderId());

        //Then
        assertEquals(user, optionalOrder2.orElse(new Order()).getUser());

        //CleanUp
        orderRepository.deleteAll();
    }

    @Test
    public void testDeleteOrder() {
        //Given
        prepareDataTests();

        //When
        Order savedOrder1 = orderRepository.save(order1);
        orderRepository.delete(savedOrder1);

        //Then
        assertFalse(orderRepository.findAll().contains(savedOrder1));
    }

    @Test
    public void saveOrder() {
        //Given
        long numbersOfOrdersBefore = orderRepository.count();
        prepareDataTests();

        //When
        Order savedOrder1 = orderRepository.save(order1);
        Order savedOrder2 = orderRepository.save(order2);

        //Then
        assertEquals(numbersOfOrdersBefore + 2, orderRepository.count());

        //CleanUp
        orderRepository.deleteAll();
    }
}
