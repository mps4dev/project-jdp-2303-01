package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("v1/products")
@RestController
@CrossOrigin("*")
public class ProductController {
    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(null);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }
}