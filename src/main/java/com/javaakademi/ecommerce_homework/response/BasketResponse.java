package com.javaakademi.ecommerce_homework.response;

import com.javaakademi.ecommerce_homework.dto.BasketProductDto;
import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasketResponse {
    private String userId;
    private int status;
    private double totalBasketAmount;
    private List<BasketProductDto> basketProducts;
}
