package com.javaakademi.ecommerce_homework.domain.productcategory.web;

import com.javaakademi.ecommerce_homework.domain.productcategory.api.ProductCategoryDto;
import com.javaakademi.ecommerce_homework.domain.productcategory.api.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService service;

    @PostMapping("/{shopId}")
    private ProductCategoryResponse createProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest, @PathVariable int shopId) {
        return toResponse(service.createProductCategory(toDto(productCategoryRequest), shopId));
    }

    @DeleteMapping("/{id}")
    public void deleteProductCategory(@PathVariable int id) {
        service.deleteProductCategory(id);
    }

    @GetMapping
    public List<ProductCategoryResponse> getAllProductCategories() {
        return toResponseList(service.getAllProductCategories());
    }

    public static ProductCategoryResponse toResponse(ProductCategoryDto dto) {
        return ProductCategoryResponse.builder()
                .productCategoryName(dto.getName())
                .shopName(dto.getName())
                .products(dto.getProducts())
                .build();
    }

    public static ProductCategoryDto toDto(ProductCategoryRequest request) {
        return ProductCategoryDto.builder()
                .name(request.getProductCategoryName())
                .build();
    }

    public static List<ProductCategoryResponse> toResponseList(List<ProductCategoryDto> dtos) {
        return dtos.stream()
                .map(ProductCategoryController::toResponse)
                .collect(Collectors.toList());
    }
}
