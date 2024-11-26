package com.javaakademi.ecommerce_homework.domain.productcategory.api;

import com.javaakademi.ecommerce_homework.domain.productcategory.impl.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategoryDto createProductCategory(ProductCategoryDto dto, int shopId);
    void deleteProductCategory(int id);
    List<ProductCategoryDto> getAllProductCategories();
}
