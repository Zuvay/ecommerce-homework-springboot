package com.javaakademi.ecommerce_homework.domain.basketproduct.api;

import com.javaakademi.ecommerce_homework.domain.product.api.ProductDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BasketProductDto {
    private int id;
    private double basketProductAmount;
    private int totalBasketProductCount;
    private int productId;
    private int basketId;
}
