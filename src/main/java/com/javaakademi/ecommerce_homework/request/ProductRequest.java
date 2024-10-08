package com.javaakademi.ecommerce_homework.request;

import java.util.List;

public class ProductRequest {
    private String name;
    private double price;
    private String categoryName;

    public ProductRequest(){}

    public ProductRequest(String name, double price, String categoryName) {
        this.name = name;
        this.price = price;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}