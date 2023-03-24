package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDTO;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/carts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {

    private final CartMapper cartMapper;
    private final CartService cartService;
    private final OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCart(CartDTO cartDto) {
        Cart creatCart = cartMapper.mapToCart(cartDto);
        cartService.createCart(creatCart);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "{cartId}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable long cartId) throws CartNotFoundException {
        Cart cart = cartService.getCartById(cartId);
        return ResponseEntity.ok(cartMapper.mapToCartDTO(cart));
    }


    @PutMapping
    public ResponseEntity<CartDTO> updateCart(@RequestBody CartDTO cartDto) {
        Cart cart = cartMapper.mapToCart(cartDto);
        Cart saveCart = cartService.createCart(cart);
        return ResponseEntity.ok(cartMapper.mapToCartDTO(saveCart));
    }


    @DeleteMapping(value = "/{cartId}")
    public ResponseEntity<Void> deleteProductFromCart(@PathVariable long cartId, @RequestParam Long productId) throws CartNotFoundException {
        cartService.removeFromCart(cartId, productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{cartId}")
    public ResponseEntity<Void> createOrderFromCart(@PathVariable long cartId) {
        orderService.createOrderBasedOnCart(cartId);
        return ResponseEntity.ok().build();
    }
}

