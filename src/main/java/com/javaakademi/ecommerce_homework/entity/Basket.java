package com.javaakademi.ecommerce_homework.entity;

import com.javaakademi.ecommerce_homework.service.BasketStatus;
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
    private BasketStatus status;

    public Basket() {
    }

    public Basket(int id, List<BasketProduct> basketProducts, BasketStatus status) {
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

    public BasketStatus getStatus() {
        return status;
    }

    public void setStatus(BasketStatus status) {
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
