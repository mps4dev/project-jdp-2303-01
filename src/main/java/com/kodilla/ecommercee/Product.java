package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private long produtId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "group_id")
    private Group group;
}
