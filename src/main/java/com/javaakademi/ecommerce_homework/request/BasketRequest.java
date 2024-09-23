package com.javaakademi.ecommerce_homework.request;

public class BasketRequest {
    private String productName;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BasketRequest(){}

    public BasketRequest(String productName,int amount) {
        this.productName = productName;
        this.amount=amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
