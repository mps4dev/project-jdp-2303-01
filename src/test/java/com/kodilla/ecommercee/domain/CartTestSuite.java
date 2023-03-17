package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    private Cart cart1;
    private Group group1;
    private Product product1;
    private Product product2;
    private User user1;

    private void dataForTests() {
        group1 = new Group(null, "group1", new ArrayList<>());
        product1 = new Product(null, "product1", 22.2, 100, group1);
        product2 = new Product(null, "product2", 37.5, 1000, group1);
        cart1 = new Cart(null, new ArrayList<>(), user1);
    }

    @Test
    public void shouldCreateEmptyCart() {

        //Given
        dataForTests();

        //When
        Cart createCart = cartRepository.save(cart1);
        List<Product> emptyCartSize = createCart.getProducts();

        //Then
        assertEquals(1, cartRepository.count());
        assertTrue(emptyCartSize.isEmpty());

        //CleanUp
        cartRepository.deleteAll();
        productRepository.deleteAll();
        groupRepository.deleteAll();
    }

    @Test
    public void shouldGetProductsFromEmptyCart() {

        //Given
        dataForTests();

        //When
        cartRepository.save(cart1);
        Cart savedCard = cartRepository.findById(cart1.getCartId()).orElse(null);
        List<Product> productsInCart = savedCard.getProducts();

        //Then
        assertEquals(0, productsInCart.size());

        //CleanUp
        cartRepository.deleteAll();
    }

    @Test
    public void shouldAddProductToCart() {

        //Given
        dataForTests();

        //When
        groupRepository.save(group1);
        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Cart createEmptyCart = cartRepository.save(cart1);
        createEmptyCart.getProducts().add(savedProduct1);
        createEmptyCart.getProducts().add(savedProduct2);
        cartRepository.save(cart1);
        Cart retrievedCart = cartRepository.findById(cart1.getCartId()).orElse(null);

        //Then
        assertNotNull(retrievedCart);
        assertEquals(2, retrievedCart.getProducts().size());
        assertTrue(cart1.getProducts().contains(product1));
        assertTrue(cart1.getProducts().contains(product2));

        //CleanUp
        cartRepository.deleteAll();
        productRepository.deleteAll();
        groupRepository.deleteAll();

    }

    @Test
    public void shouldDeleteProductFromCart() {

        //Given
        dataForTests();

        //When
        groupRepository.save(group1);
        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Cart createEmptyCart = cartRepository.save(cart1);
        createEmptyCart.getProducts().add(savedProduct1);
        createEmptyCart.getProducts().add(savedProduct2);
        productRepository.delete(createEmptyCart.getProducts().remove(0));
        cartRepository.save(cart1);

        //Then
        assertNotEquals(2, cart1.getProducts().size());
        assertEquals(1, cart1.getProducts().size());
        assertEquals("product2", cart1.getProducts().get(0).getName());

        //CleanUp
        cartRepository.deleteAll();
        productRepository.deleteAll();
        groupRepository.deleteAll();
    }

    @Test
    public void shouldFindProductsInCart() {

        //Given
        dataForTests();

        //When
        groupRepository.save(group1);
        productRepository.save(product1);
        productRepository.save(product2);
        cartRepository.save(cart1);
        cart1.getProducts().add(product1);
        cart1.getProducts().add(product2);
        cartRepository.save(cart1);
        Cart getCart = cartRepository.findById(cart1.getCartId()).orElse(null);
        List<Product> findproducts = getCart.getProducts();

        //Then
        assertEquals(2, findproducts.size());

        //CleanUp
        cartRepository.deleteAll();
        productRepository.deleteAll();
        groupRepository.deleteAll();
    }


}
