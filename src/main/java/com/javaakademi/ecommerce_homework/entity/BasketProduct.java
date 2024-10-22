package com.javaakademi.ecommerce_homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double basketProductAmount; //total fiyat
    private int totalBasketProductCount; //ürün sayısı
    @OneToOne
    private Product product;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    @JsonIgnore
    private Basket basket;

    public BasketProduct() {
    }

    public BasketProduct(int id, double basketProductAmount, int totalBasketProductCount, Product product, Basket basket) {
        this.id = id;
        this.basketProductAmount = basketProductAmount;
        this.totalBasketProductCount = totalBasketProductCount;
        this.product = product;
        this.basket = basket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasketProductAmount() {
        return basketProductAmount;
    }

    public void setBasketProductAmount(double basketProductAmount) {
        this.basketProductAmount = basketProductAmount;
    }

    public int getTotalBasketProductCount() {
        return totalBasketProductCount;
    }

    public void setTotalBasketProductCount(int totalBasketProductCount) {
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