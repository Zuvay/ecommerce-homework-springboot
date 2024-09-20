package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Basket(int id, User user) {
        this.id = id;
    }
    public Basket(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
