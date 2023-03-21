package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {
    public Product mapToProduct(final ProductDTO productDTO) {
        return new Product(productDTO.getProductId(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getQuantity(),
                productDTO.getGroup());

    }

    public ProductDTO mapToProductDTO(final Product product) {
        return new ProductDTO(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getGroup());
    }

    public List<ProductDTO> mapToProductDTOList(List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDTO)
                .collect(Collectors.toList());
    }
}
