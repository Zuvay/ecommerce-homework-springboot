package com.javaakademi.ecommerce_homework.domain.shop.impl;

import com.javaakademi.ecommerce_homework.domain.shop.api.ShopDto;
import com.javaakademi.ecommerce_homework.domain.shop.api.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public ShopDto findById(int id) {
        Shop shop = shopRepository.findById(id).orElseThrow();
        return toDto(shop);
    }


    public ShopDto createShop(ShopDto dto) {
        Shop shop = toEntity(dto);
        shopRepository.save(shop);
        return toDto(shop);
    }

    public Shop findShopById(int id) {
        return shopRepository.findById(id).orElseThrow();
    }

    public static Shop toEntity(ShopDto dto) {
        Shop shop = new Shop();
        shop.setShopName(dto.shopName);
        return shop;
    }

    public static ShopDto toDto(Shop shop) {
        ShopDto dto = new ShopDto();
        dto.shopName = shop.getShopName();
        dto.id = shop.getId();
        return dto;
    }
}
