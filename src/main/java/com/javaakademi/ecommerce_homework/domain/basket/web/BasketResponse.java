package com.javaakademi.ecommerce_homework.domain.basket.web;

import com.javaakademi.ecommerce_homework.domain.basketproduct.api.BasketProductDto;
import com.javaakademi.ecommerce_homework.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketResponse  extends BaseResponse {
    private int userId;
    private int status;
    private double totalBasketAmount;
    private List<BasketProductDto> basketProducts;
}
