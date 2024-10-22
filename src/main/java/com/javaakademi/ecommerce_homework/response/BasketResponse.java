package com.javaakademi.ecommerce_homework.response;

import com.javaakademi.ecommerce_homework.entity.BasketProduct;

import java.util.List;

public class BasketResponse {
    private String user;
    private int status;
    private double totalBasketAmount;
    private List<BasketProduct> basketProducts;

    public BasketResponse(){}

    public BasketResponse(String user, int status, double totalBasketCount) {
        this.user = user;
        this.status = status;
        this.totalBasketAmount = totalBasketCount;

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotalBasketAmount() {
        return totalBasketAmount;
    }

    public void setTotalBasketAmount(double totalBasketAmount) {
        this.totalBasketAmount = totalBasketAmount;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }
}
