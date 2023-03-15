package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
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
        product1 = new Product("Dell", 3000, 10, group1);
        product2 = new Product("MacBook", 6000, 10, group1);
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
        productRepository.deleteAll();
    }

    @Test
    public void testUpdateData() {
// Given
          createTestData();
// When
        groupRepository.save(group1);
        productRepository.save(product1);
        productRepository.save(product2);
        String updatedData = "MacBook M2";
        product1 = new Product(updatedData, product1.getPrice(), product1.getQuantity(), product1.getGroup());
        Product updatedProduct = productRepository.save(product1);

// Then
        assertEquals(updatedData, updatedProduct.getName());

// CleanUp
        productRepository.deleteAll();
    }

    @Test

    public void testProductRepositoryFindAll() {

        //Given
        createTestData();
        //When
        groupRepository.save(group1);
        productRepository.save(product1);
        productRepository.save(product2);
        List<Product> retrievedProductList = productRepository.findAll();

        //Then
        assertEquals(2, retrievedProductList.size());
        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void testProductRepositoryGet() {

        //Given
        createTestData();

        //When
        groupRepository.save(group1);
        productRepository.save(product1);
        productRepository.save(product2);
        Optional<Product> retrievedProduct = productRepository.findById(product1.getProductId());

        //Then
        assertTrue(retrievedProduct.isPresent());
        assertEquals("Dell", retrievedProduct.orElse(new Product()).getName());

        //CleanUp
        productRepository.deleteAll();
       }
}