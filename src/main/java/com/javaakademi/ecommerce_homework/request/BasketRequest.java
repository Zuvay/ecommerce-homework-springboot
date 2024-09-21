package com.javaakademi.ecommerce_homework.request;

public class BasketRequest {
    private String productName;
    public BasketRequest(){}

    public BasketRequest(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
