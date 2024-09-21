package com.javaakademi.ecommerce_homework.response;

import com.javaakademi.ecommerce_homework.entity.Product;

import java.util.List;

public class BasketResponse {
    private List<String> products;
    public BasketResponse(){}
    public BasketResponse(List<String> products) {
        this.products = products;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
