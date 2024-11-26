package com.javaakademi.ecommerce_homework.domain.basket.api;

import com.javaakademi.ecommerce_homework.domain.basket.web.BasketRequest;
import com.javaakademi.ecommerce_homework.domain.basketproduct.api.BasketProductDto;

import java.util.List;


public interface BasketService {
    BasketDto saveBasket(BasketDto dto);

    List<BasketProductDto> getProducts();

    double getTotalAmount();

    int findBasketStatusByBasketId();
}
