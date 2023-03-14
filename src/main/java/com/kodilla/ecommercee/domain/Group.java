package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue
    private Long groupId;

    @NotNull
    @Column(name = "name",unique = true)
    private String name;

    public Group(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    @OneToMany(targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Product> products = new ArrayList<>();
}
