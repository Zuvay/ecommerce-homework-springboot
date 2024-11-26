package com.javaakademi.ecommerce_homework.domain.product.api;

import com.javaakademi.ecommerce_homework.domain.productcategory.api.ProductCategoryDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {
        private int id;
        private String name;
        private double price;
        private int categoryId;
}
