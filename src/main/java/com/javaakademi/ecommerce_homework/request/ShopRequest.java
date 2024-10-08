package com.javaakademi.ecommerce_homework.request;

import com.javaakademi.ecommerce_homework.service.ShopService;

public class ShopRequest {
    private String shopName;
    public ShopRequest(){}

    public ShopRequest(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
