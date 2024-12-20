package com.javaakademi.ecommerce_homework.domain.shop.web;

import com.javaakademi.ecommerce_homework.response.BaseResponse;

public class ShopResponse  extends BaseResponse {
    private int id;
    private String shopName;
    public ShopResponse(){}

    public ShopResponse(int id, String shopName) {
        this.id = id;
        this.shopName = shopName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
