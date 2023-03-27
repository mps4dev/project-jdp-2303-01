package com.kodilla.ecommercee.security;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.kodilla.ecommercee.security.UserPermission.*;

@Getter
public enum UserRole {
    USER(Sets.newHashSet(PRODUCT_READ, PRODUCT_GROUP_READ,CART_WRITE,ORDER_WRITE,USER_BLOCK)),
    ADMIN(Sets.newHashSet(PRODUCT_WRITE,PRODUCT_GROUP_WRITE,USER_BLOCK));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
