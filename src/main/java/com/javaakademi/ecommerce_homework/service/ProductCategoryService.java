package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;
import com.javaakademi.ecommerce_homework.repository.ProductCategoryRepository;
import com.javaakademi.ecommerce_homework.request.ProductCategoryRequest;
import com.javaakademi.ecommerce_homework.response.ProductCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    public ProductCategoryResponse createProductCategory(ProductCategoryRequest request){
        repository.save(toEntity(request));
        return toResponse(toEntity(request));
    }
    public ProductCategory toEntity(ProductCategoryRequest request){
        ProductCategory category = new ProductCategory();
        category.setName(request.getProductCategoryName());
        return category;
    }

    public ProductCategoryResponse toResponse(ProductCategory category){
        ProductCategoryResponse response = new ProductCategoryResponse();
        response.setProductCategoryName(category.getName());
        return response;
    }
}
