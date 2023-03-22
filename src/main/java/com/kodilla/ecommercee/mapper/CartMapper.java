package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDTO;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {
    public Cart mapToCart(CartDTO cartDTO) {
        return new Cart(cartDTO.getCartId(),
                cartDTO.getProducts(),
                cartDTO.getUser());
    }

    public CartDTO mapToCartDTO(Cart cart) {
        return new CartDTO(cart.getCartId(),
                cart.getProducts(),
                cart.getUser());
    }
}
