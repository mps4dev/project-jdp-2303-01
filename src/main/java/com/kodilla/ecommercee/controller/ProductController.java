package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDTO;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/products")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<Product> productList = productService.showProducts();
        return ResponseEntity.ok(productMapper.mapToProductDTOList(productList));
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable long productId) throws ProductNotFoundException {
        Product foundProduct = productService.showProduct(productId);
        return ResponseEntity.ok(productMapper.mapToProductDTO(foundProduct));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.mapToProduct(productDTO);
        productService.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.mapToProduct(productDTO);
        Product updatedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(productMapper.mapToProductDTO(updatedProduct));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}