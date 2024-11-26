package com.javaakademi.ecommerce_homework.domain.shop.api;

public interface ShopService {

    public ShopDto createShop(ShopDto dto);
    public ShopDto findById(int id);
}
