package com.javaakademi.ecommerce_homework.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BasketDto {

    private int id;

    private List<BasketProductDto> basketProducts;
    private UserDto user;
    private double totalBasketAmount;
    private int status;
}
