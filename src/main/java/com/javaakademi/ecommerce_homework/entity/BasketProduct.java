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
    private Product product; //Birden çok ürün bir BasketProductta olabilir.
    @ManyToOne
    private Basket basket; //Bir sepette birden çok basketproduct

    public BasketProduct(){}
    //const ve getter setterlar eklenecek
    
}