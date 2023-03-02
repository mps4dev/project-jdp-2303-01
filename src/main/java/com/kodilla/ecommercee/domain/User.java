package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @JsonProperty("userId")
    private Long userId;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "userkey_value")),
            @AttributeOverride(name = "expirationTime", column = @Column(name = "userkey_expiration_time"))
    })
    @JsonProperty("user_key")
    private UserKey userKey;

    @NotNull
    private boolean isBlocked;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonBackReference("orderReference")
    private List<Order> orders = new ArrayList<>();

    public User(Long userId, String name, String lastName, String address, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.login = login;
        this.password = password;
        this.isBlocked = false;
    }
}

