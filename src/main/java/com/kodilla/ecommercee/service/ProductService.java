package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDTO;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
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
    private final ProductMapper productMapper;

    public List<ProductDTO> showProducts() {
        return productMapper.mapToProductDTOList(productRepository.findAll());
    }

    public ProductDTO showProduct(final long productId) throws ProductNotFoundException {
        if (productRepository.existsById(productId)) {
            return productMapper.mapToProductDTO(productRepository.findById(productId).get());
        } else {
            System.out.println("Product with  Id " + productId + " not found");
            throw new ProductNotFoundException();
        }
    }

    public void saveProduct(final ProductDTO productDTO) {
        Product product = productMapper.mapToProduct(productDTO);
        productRepository.save(product);
    }

    public ProductDTO updateProduct(final ProductDTO productDTO) {
        Product product = productMapper.mapToProduct(productDTO);
        Product updatedProduct = productRepository.save(product);
        return productMapper.mapToProductDTO(updatedProduct);
    }

    public void deleteProduct(final long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.deleteById(productId);
        } else {
            System.out.println("Product with  Id " + productId + " not found");
            throw new ProductNotFoundException();
        }
    }
}
