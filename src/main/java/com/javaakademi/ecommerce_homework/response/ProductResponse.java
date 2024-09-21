package com.javaakademi.ecommerce_homework.response;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;

import java.util.List;

public class ProductResponse {
    private String name;
    private double price;
    private int amount;
    private List<String> categories;
    public ProductResponse(){}

    public ProductResponse(String name, double price, int amount, List<String> categories) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.categories = categories;
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
