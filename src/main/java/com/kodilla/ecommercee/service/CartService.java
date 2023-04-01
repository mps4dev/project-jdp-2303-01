package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;

import com.kodilla.ecommercee.domain.dto.CartDTO;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    public Cart createCart(CartDTO cartDTO) {
        Cart cart = cartMapper.mapToCart(cartDTO);
        return cartRepository.save(cart);
    }

    public CartDTO getCartById(final long cartId) throws CartNotFoundException {
        if (cartRepository.existsById(cartId)) {
            return cartMapper.mapToCartDTO(cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new));
        } else {
            System.out.println("Cart with  Id " + cartId + " not found");
            throw new CartNotFoundException();
        }
    }

    public void removeFromCart(long cartId, long productId) throws CartNotFoundException, ProductNotFoundException {
        if (cartRepository.existsById(cartId) && productRepository.existsById(productId)) {
            Cart cart = cartRepository.findById(cartId).get();
            List<Product> products = cart.getProducts();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductId() == productId) {
                    products.remove(i);
                    break;
                }
            }
            cartRepository.save(cart);
        } else if (!cartRepository.existsById(cartId)) {
            System.out.println("Cart with  Id " + cartId + " not found");
            throw new CartNotFoundException();
        } else if (!productRepository.existsById(productId)) {
            System.out.println("Product with  Id " + productId + " not found");
            throw new ProductNotFoundException();
        }
    }

    public CartDTO addProductToCart(long cartId, long productId) throws CartNotFoundException, ProductNotFoundException {

        if (cartRepository.existsById(cartId) && productRepository.existsById(productId)) {
            Cart cart = cartRepository.findById(cartId).get();
            Product product = productRepository.findById(productId).get();
            cart.getProducts().add(product);
            return cartMapper.mapToCartDTO(cartRepository.save(cart));
        } else if (!cartRepository.existsById(cartId)) {
            System.out.println("Cart with  Id " + cartId + " not found");
            throw new CartNotFoundException();
        } else if (!productRepository.existsById(productId)) {
            System.out.println("Product with  Id " + productId + " not found");
            throw new ProductNotFoundException();
        }
        return null;
    }
}





