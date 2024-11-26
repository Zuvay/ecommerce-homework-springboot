package com.javaakademi.ecommerce_homework.domain.productcategory.api;

import com.javaakademi.ecommerce_homework.domain.product.api.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDto {
    private int id;
    private String name;
    private List<ProductDto> products;
    private int shopId;
}
