package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"groups\"") //SQL syntax error - słowo groups zarezerwowane przez SQL
public class Group {
    @Id
    @GeneratedValue
    private Long groupId;

    @NotNull
    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Product> products = new ArrayList<>();
}
