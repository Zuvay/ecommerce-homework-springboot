package com.javaakademi.ecommerce_homework.domain.productcategory.web;

import com.javaakademi.ecommerce_homework.domain.product.api.ProductDto;
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
public class ProductCategoryResponse extends BaseResponse {
    private String productCategoryName;
    private String shopName;
    private List<ProductDto> products;
}
