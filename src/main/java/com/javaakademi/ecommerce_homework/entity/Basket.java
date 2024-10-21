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
    private double totalBasketAmount; //Total fiyat
    private int status;

    public Basket() {
    }

    public Basket(int id, List<BasketProduct> basketProducts, int status) {
        this.id = id;
        this.basketProducts = basketProducts;
        this.status = status;
    }

    public double getTotalBasketAmount() {
        return totalBasketAmount;
    }

    public void setTotalBasketCount(double totalBasketAmount) {
        this.totalBasketAmount = totalBasketAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
