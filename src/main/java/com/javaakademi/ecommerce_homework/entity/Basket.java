package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BasketProduct> basketProducts;
    @OneToOne
    private User user;
    private double totalBasketAmount; //Total fiyat
    private int status;

    public Basket() {
    }

    public Basket(int id, List<BasketProduct> basketProducts, User user, double totalBasketAmount, int status) {
        this.id = id;
        this.basketProducts = basketProducts;
        this.user = user;
        this.totalBasketAmount = totalBasketAmount;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalBasketAmount() {
        return totalBasketAmount;
    }

    public void setTotalBasketAmount(double totalBasketAmount) {
        this.totalBasketAmount = totalBasketAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
