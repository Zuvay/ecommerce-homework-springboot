package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private int amount;
    @ManyToMany(cascade = CascadeType.REMOVE)//Bununla birlikte eğer bir categori silmek istersem onunla birlikte tüm itemler silinmiş olacak
    private List<ProductCategory> categories;
    public Product(){}

    public Product(int id, String name, double price, int amount, List<ProductCategory> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }
}
