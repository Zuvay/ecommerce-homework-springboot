package com.javaakademi.ecommerce_homework.response;

import com.javaakademi.ecommerce_homework.entity.Basket;

import java.util.List;

public class BasketResponse {
    private List<ProductAmount> products;
    private String user;
    private String status;

    public BasketResponse(List<ProductAmount> products, String user, String status) {
        this.products = products;
        this.user = user;
        this.status = status;
    }
    public BasketResponse(){}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductAmount> getProducts() {
        return products;
    }

    public void setProducts(List<ProductAmount> products) {
        this.products = products;
    }
}
