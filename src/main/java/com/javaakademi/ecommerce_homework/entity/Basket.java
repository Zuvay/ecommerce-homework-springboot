package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User user_id;
    @OneToMany
    private List<BasketProduct> basketProducts; //bir sepette birden çok sepet ürünü olabilir.
    
    public Basket(){}

    public Basket(int id, User user_id, List<BasketProduct> basketProducts) {
        this.id = id;
        this.user_id = user_id;
        this.basketProducts = basketProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }
}
