package com.javaakademi.ecommerce_homework.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BasketProductDto {

    private int id;
    private double basketProductAmount;
    private int totalBasketProductCount;
    private ProductDto product;
    private int basketId;
}
