package com.javaakademi.ecommerce_homework.response;


public class BasketProductResponse {
    private double basketProductAmount;
    private double totalBasketProductCount;
    private String product;
    private int basketID;

    public void setBasketProductAmount(double basketProductAmount) {
        this.basketProductAmount = basketProductAmount;
    }

    public double getTotalBasketProductCount() {
        return totalBasketProductCount;
    }

    public void setTotalBasketProductCount(double totalBasketProductCount) {
        this.totalBasketProductCount = totalBasketProductCount;
    }

    public int getBasketID() {
        return basketID;
    }

    public void setBasketID(int basketID) {
        this.basketID = basketID;
    }

    public BasketProductResponse() {
    }

    public BasketProductResponse(double basketProductAmount, String product) {
        this.basketProductAmount = basketProductAmount;
        this.product = product;
    }

    public double getBasketProductAmount() {
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
