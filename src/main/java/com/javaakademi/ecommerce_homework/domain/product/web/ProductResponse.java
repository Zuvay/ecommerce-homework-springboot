package com.javaakademi.ecommerce_homework.domain.product.web;

import com.javaakademi.ecommerce_homework.domain.productcategory.api.ProductCategoryDto;
import com.javaakademi.ecommerce_homework.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse extends BaseResponse {
    private String name;
    private double price;
    private int categoryId;
}
