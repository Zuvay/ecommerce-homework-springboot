package com.javaakademi.ecommerce_homework.response;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import jakarta.persistence.OneToMany;

import java.util.List;

public class BasketResponse {
    private String user;
    private String status;
    private double totalBasketCount;
    private List<BasketProduct> basketProducts;

    public BasketResponse(){}

    public BasketResponse(String user, String status, double totalBasketCount) {
        this.user = user;
        this.status = status;
        this.totalBasketCount = totalBasketCount;

    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }

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

    public double getTotalBasketCount() {
        return totalBasketCount;
    }

    public void setTotalBasketCount(double totalBasketCount) {
        this.totalBasketCount = totalBasketCount;
    }

}
