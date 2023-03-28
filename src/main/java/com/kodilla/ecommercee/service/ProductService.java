package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> showProducts() {
        return productRepository.findAll();
    }

    public Product showProduct(final long productId) throws ProductNotFoundException {
        if (productRepository.existsById(productId)){
        return productRepository.findById(productId).get();
        }else {
            System.out.println("Product with  Id " + productId+ " not found" );
            throw new ProductNotFoundException();
        }
    }

    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(final long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
      productRepository.deleteById(productId);
        }else {
            System.out.println("Product with  Id " + productId+ " not found" );
            throw new ProductNotFoundException();
        }

    }

}
