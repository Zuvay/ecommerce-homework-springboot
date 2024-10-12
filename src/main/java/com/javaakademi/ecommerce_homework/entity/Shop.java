package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String shopName;
    @OneToMany
    private List<ProductCategory> shopCategories;

    public Shop() {
    }

    public Shop(int id, String shopName, List<ProductCategory> shopCategories) {
        this.id = id;
        this.shopName = shopName;
        this.shopCategories = shopCategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<ProductCategory> getCategories() {
        return shopCategories;
    }

    public void setCategories(List<ProductCategory> shopCategories) {
        this.shopCategories = shopCategories;
    }
}