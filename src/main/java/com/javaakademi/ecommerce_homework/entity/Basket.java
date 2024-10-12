package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private List<BasketProduct> basketProducts;
    @OneToOne
    private User user;
    private double totalBasketCount;
    private String status;

    public Basket() {
    }

    public Basket(int id, List<BasketProduct> basketProducts, String status) {
        this.id = id;
        this.basketProducts = basketProducts;
        this.status = status;
    }

    public double getTotalBasketCount() {
        return totalBasketCount;
    }

    public void setTotalBasketCount(double totalBasketCount) {
        this.totalBasketCount = totalBasketCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }
}
