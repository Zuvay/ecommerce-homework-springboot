package com.javaakademi.ecommerce_homework.request;

import java.util.List;

public class ProductRequest {
    private String name;
    private double price;
    private int amount;
    private List<String> categoryNames;

    public ProductRequest(){}

    public ProductRequest(String name, double price, int amount, List<String> categoryNames) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.categoryNames = categoryNames;
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

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }
}





