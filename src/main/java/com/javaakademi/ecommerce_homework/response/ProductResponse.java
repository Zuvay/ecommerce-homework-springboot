package com.javaakademi.ecommerce_homework.response;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;

import java.util.List;

public class ProductResponse {
    private String name;
    private double price;
    private List<String> categories;
    public ProductResponse(){}

    public ProductResponse(String name, double price, int amount, List<String> categories) {
        this.name = name;
        this.price = price;
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


    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
