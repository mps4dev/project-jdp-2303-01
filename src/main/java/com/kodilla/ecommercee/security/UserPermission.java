package com.kodilla.ecommercee.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserPermission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    PRODUCT_GROUP_READ("productGroup:read"),
    PRODUCT_GROUP_WRITE("productGroup:write"),
    CART_WRITE("cart:write"),
    ORDER_WRITE("order:write"),
    USER_CREATE("user:create"),
    USER_BLOCK("user:block");
    private final String permission;
}
