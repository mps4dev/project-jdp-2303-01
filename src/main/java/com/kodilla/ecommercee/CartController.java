package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.CartDTO;
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

    @GetMapping
    public ResponseEntity<List<CartDTO>> getItemsFromCart(){
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "{itemId}")
    public ResponseEntity<CartDTO> addItemToCart(@PathVariable Long itemId){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "{itemId}")
    public ResponseEntity<Void> deleteItemFromCart(@PathVariable Long itemId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "createOrderFromCart", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> createOrderFromCart(){
            return ResponseEntity.ok().build();
        }
}
