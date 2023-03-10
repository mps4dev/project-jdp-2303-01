package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.CartDTO;
import com.kodilla.ecommercee.dto.OrderDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/carts")
public class CartController {


    @PostMapping
    public ResponseEntity<Void> createCart(@RequestBody CartDTO cartDto){
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{cartId}")
    public ResponseEntity<List<CartDTO>> getCartById(@PathVariable Long cartId){
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<CartDTO> updateCart(@RequestBody CartDTO cartDto){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{cartId}")
    public ResponseEntity<Void> deleteItemFromCart(@PathVariable Long cartId, @RequestParam Long productId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{cartId}/order")
    public ResponseEntity<Void> createOrderFromCart(@PathVariable Long cartId, @RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok().build();
    }
}
