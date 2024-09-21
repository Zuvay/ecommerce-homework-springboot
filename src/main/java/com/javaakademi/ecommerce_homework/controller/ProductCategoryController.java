package com.javaakademi.ecommerce_homework.controller;

import com.javaakademi.ecommerce_homework.request.ProductCategoryRequest;
import com.javaakademi.ecommerce_homework.response.ProductCategoryResponse;
import com.javaakademi.ecommerce_homework.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping
    private ProductCategoryResponse createCategory(@RequestBody ProductCategoryRequest request){
        return productCategoryService.createProductCategory(request);
    }
}
