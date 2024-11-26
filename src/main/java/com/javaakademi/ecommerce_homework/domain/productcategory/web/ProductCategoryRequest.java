package com.javaakademi.ecommerce_homework.domain.productcategory.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryRequest {
    private String productCategoryName;

}
