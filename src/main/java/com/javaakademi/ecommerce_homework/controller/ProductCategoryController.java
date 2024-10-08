package com.javaakademi.ecommerce_homework.controller;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;
import com.javaakademi.ecommerce_homework.request.ProductCategoryRequest;
import com.javaakademi.ecommerce_homework.request.ProductRequest;
import com.javaakademi.ecommerce_homework.response.ProductCategoryResponse;
import com.javaakademi.ecommerce_homework.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/{shopID}")//iki işi aynı anda yapması problem. Hem categoriyi oluşturuyo hem de ilgili mağazaya atıyor
    private ProductCategoryResponse createProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest,@PathVariable int shopID){
        return productCategoryService.createProductCategory(productCategoryRequest,shopID);
    }
    @DeleteMapping("/{id}")
    public void deleteProductCategory(@PathVariable int id){
        productCategoryService.deleteProductCategory(id);
    }
    @GetMapping
    public List<ProductCategoryResponse> getAllProductCategories(){
        return productCategoryService.getAllProductCategories();
    }
    @PutMapping("/{id}")
    public ProductCategoryResponse updateProductCategory(@RequestBody ProductCategoryRequest request,@PathVariable int id){
        return productCategoryService.updateProductCategory(request,id);
    }
}
