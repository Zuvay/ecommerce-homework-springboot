package com.javaakademi.ecommerce_homework.domain.basketproduct.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketProductResponse {
    private double basketProductAmount;
    private double totalBasketProductCount;
    private String product;
    private int basketId;
}
