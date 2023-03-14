package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    GroupRepository groupRepository;
    private Group group1;
    private Product product1;
    private Product product2;

    public void createTestData() {
        group1 = new Group("Electronics", new ArrayList<>());
        product1 = new Product("Laptop", 3000, 10, group1);
        product2 = new Product("MacBook", 6000, 10, group1);
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);
    }

    public void deleteTestData() {
        try {
            productRepository.delete(product1);
            productRepository.delete(product2);
            groupRepository.delete(group1);
        } catch (Exception e) {
            System.out.println("Objects were not deleted! Error: " + e);
        }
    }

    @Test
    public void testSaveProducts() {
// Given
        createTestData();
// When
        groupRepository.save(group1);
        productRepository.save(product1);
        productRepository.save(product2);
// Then
        assertNotEquals(0, groupRepository.count());
        assertNotEquals(0, productRepository.count());
// CleanUp
        deleteTestData();
    }
}