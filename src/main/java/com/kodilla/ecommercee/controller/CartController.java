package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDTO;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
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
    private final CartService cartService;
    private final OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCart(CartDTO cartDto) {
        cartService.createCart(cartDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{cartId}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable long cartId) throws CartNotFoundException {
        return ResponseEntity.ok(cartService.getCartById(cartId));
    }

    @PutMapping(value = "/{cartId}")
    public ResponseEntity<CartDTO> updateProductInCart(@PathVariable long cartId, @RequestParam long productId) throws CartNotFoundException, ProductNotFoundException {
        return ResponseEntity.ok(cartService.addProductToCart(cartId, productId));
    }

    @DeleteMapping(value = "/{cartId}")
    public ResponseEntity<Void> deleteProductFromCart(@PathVariable long cartId, @RequestParam long productId) throws CartNotFoundException, ProductNotFoundException {
        cartService.removeFromCart(cartId, productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{cartId}")
    public ResponseEntity<Void> createOrderFromCart(@PathVariable long cartId) throws CartNotFoundException {
        orderService.createOrderBasedOnCart(cartId);
        return ResponseEntity.ok().build();
    }
}

