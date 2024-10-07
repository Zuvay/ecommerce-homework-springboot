package com.javaakademi.ecommerce_homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JsonIgnore
    private User user;
    @OneToMany
    private List<BasketProduct> basketProducts; //bir sepette birden çok sepet ürünü olabilir.

    private String status;
    
    public Basket(){}

    public Basket(int id, User user_id, List<BasketProduct> basketProducts,String status) {
        this.id = id;
        this.user = user_id;
        this.basketProducts = basketProducts;
        this.status=status;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }
}
