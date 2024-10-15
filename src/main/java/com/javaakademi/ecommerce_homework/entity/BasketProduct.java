package com.javaakademi.ecommerce_homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int basketProductAmount;
    private double totalBasketProductCount;
    @ManyToOne
    private Product product;
    @ManyToOne
    @JsonIgnore
    private Basket basket;

    public BasketProduct() {
    }

    public BasketProduct(int id, int basketProductAmount, Product product, Basket basket) {
        this.id = id;
        this.basketProductAmount = basketProductAmount;
        this.product = product;
        this.basket = basket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBasketProductAmount() {
        return basketProductAmount;
    }

    public void setBasketProductAmount(int basketProductAmount) {
        this.basketProductAmount = basketProductAmount;
    }

    public double getTotalBasketProductCount() {
        return totalBasketProductCount;
    }

    public void setTotalBasketProductCount(double totalBasketProductCount) {
        this.totalBasketProductCount = totalBasketProductCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}