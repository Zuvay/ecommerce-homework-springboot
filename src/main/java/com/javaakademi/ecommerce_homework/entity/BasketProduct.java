package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int basketProductAmount;
    private double basketProductPrice;
    @ManyToOne
    private List<Product> products;
    @ManyToOne
    private List<Basket> baskets;

    public BasketProduct(){}
    //const ve getter setterlar eklenecek
    
}