package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDTO;
import com.kodilla.ecommercee.domain.dto.OrderDTO;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCart(@RequestBody CartDTO cartDto){
        Cart creatCart = cartMapper.mapToCart(cartDto);
        cartService.createCart(creatCart);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{cartId}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable long cartId) throws CartNotFoundException {
        Cart getCart = cartService.getCartById(cartId);
        return ResponseEntity.ok(cartMapper.mapToCartDTO(getCart));
    }

    @PutMapping
    public ResponseEntity<CartDTO> updateCart(@RequestBody CartDTO cartDto){
        Cart getCart = cartMapper.mapToCart(cartDto);
        Cart saveCart = cartService.createCart(getCart);
        return ResponseEntity.ok(cartMapper.mapToCartDTO(saveCart));
    }

    @DeleteMapping(value = "/{cartId}")
    public ResponseEntity<Void> deleteProductFromCart(@PathVariable long cartId, @RequestParam Long productId) throws CartNotFoundException {
       cartService.removeFromCart(cartId,productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{cartId}/order")
    public ResponseEntity<Void> createOrderFromCart(@PathVariable long cartId, @RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok().build();
    }
}
