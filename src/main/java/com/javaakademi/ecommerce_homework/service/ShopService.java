package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;
import com.javaakademi.ecommerce_homework.entity.Shop;
import com.javaakademi.ecommerce_homework.repository.ProductCategoryRepository;
import com.javaakademi.ecommerce_homework.repository.ShopRepository;
import com.javaakademi.ecommerce_homework.request.ProductCategoryRequest;
import com.javaakademi.ecommerce_homework.request.ShopRequest;
import com.javaakademi.ecommerce_homework.response.ShopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public Shop findById(int id){
        return shopRepository.findById(id).orElseThrow();
    }

    public ShopResponse createShop(ShopRequest shopRequest){
        Shop shop = toEntity(shopRequest);
        shopRepository.save(shop);
        return toResponse(shop);
    }
    public Shop toEntity(ShopRequest shopRequest){
        Shop shop = new Shop();
        shop.setShopName(shopRequest.getShopName());
        return shop;
    }
    public ShopResponse toResponse(Shop shop){
        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setShopName(shop.getShopName());
        shopResponse.setId(shop.getId());
        return shopResponse;
    }

}
