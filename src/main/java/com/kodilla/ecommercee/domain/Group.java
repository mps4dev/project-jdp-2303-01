package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"groups\"")
public class Group {
    @Id
    @GeneratedValue
    private Long groupId;

    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonBackReference
    List<Product> products = new ArrayList<>();
}
