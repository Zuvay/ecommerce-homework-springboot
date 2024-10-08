package com.javaakademi.ecommerce_homework.response;


public class BasketProductResponse {
    private int basketProductAmount;
    private String product;
    private int basketID;

    public int getBasketID() {
        return basketID;
    }

    public void setBasketID(int basketID) {
        this.basketID = basketID;
    }

    public BasketProductResponse(){}

    public BasketProductResponse(int basketProductAmount, String product) {
        this.basketProductAmount = basketProductAmount;
        this.product = product;
    }

    public int getBasketProductAmount() {
        return basketProductAmount;
    }

    public void setBasketProductAmount(int basketProductAmount) {
        this.basketProductAmount = basketProductAmount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
