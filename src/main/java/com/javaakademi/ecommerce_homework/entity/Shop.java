package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String shopName;
    @OneToOne
    private User shopUser;
    @OneToMany
    private List<ProductCategory> categories;
    public Product(){}

    public Product(int id, String shopName,User shopUser, List<ProductCategory> categories) {
        this.id = id;
        this.shopName=shopName;
        this.shopUser=shopUser;
        this.categories = categories;
    }

    //getter ve setterlar eklenecek

}