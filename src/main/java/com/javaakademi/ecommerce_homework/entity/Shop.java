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
    private List<ProductCategory> shopCategories;
    public Shop(){}

    public Shop(int id, String shopName,User shopUser, List<ProductCategory> shopCategories) {
        this.id = id;
        this.shopName=shopName;
        this.shopUser=shopUser;
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

    public User getShopUser() {
        return shopUser;
    }

    public void setShopUser(User shopUser) {
        this.shopUser = shopUser;
    }

    public List<ProductCategory> getCategories() {
        return shopCategories;
    }

    public void setCategories(List<ProductCategory> shopCategories) {
        this.shopCategories = shopCategories;
    }
}