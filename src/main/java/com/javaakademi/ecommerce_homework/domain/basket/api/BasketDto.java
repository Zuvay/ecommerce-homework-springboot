package com.javaakademi.ecommerce_homework.domain.basket.api;

import com.javaakademi.ecommerce_homework.domain.basketproduct.api.BasketProductDto;
import com.javaakademi.ecommerce_homework.domain.user.api.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {
    private int id;
    private List<BasketProductDto> basketProducts;
    private int userId;
    private double totalBasketAmount;
    private int status;
}
