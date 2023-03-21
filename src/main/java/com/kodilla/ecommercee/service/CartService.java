package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Cart createCart(Cart cart ){
       return cartRepository.save(cart);
    }

    public Cart getCartById(final long cartId) throws CartNotFoundException {
        return cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
    }
    public void removeFromCart(long cartId, long productId)throws CartNotFoundException{
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        cart.getProducts().stream().map(Product::getProductId)
                .collect(Collectors.toList())
                .remove(productId);
        cartRepository.save(cart);
    }



}





