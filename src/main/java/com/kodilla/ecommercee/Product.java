package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private long productId;

    @Column(name = "productName")
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "group_id")   <-- relacja do encji Group
//    private Group group;

}
