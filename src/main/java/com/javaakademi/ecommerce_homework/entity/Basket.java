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
    
    //getter setter ve const eklenecek
}
