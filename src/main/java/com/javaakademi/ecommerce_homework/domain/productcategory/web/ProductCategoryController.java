package com.javaakademi.ecommerce_homework.domain.productcategory.web;

import com.javaakademi.ecommerce_homework.domain.productcategory.api.ProductCategoryDto;
import com.javaakademi.ecommerce_homework.domain.productcategory.impl.ProductCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @PostMapping("/{shopId}")
    private ProductCategoryResponse createProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest, @PathVariable int shopId) {
        return toResponse(productCategoryService.createProductCategory(toDto(productCategoryRequest), shopId));
    }

    @DeleteMapping("/{id}")
    public void deleteProductCategory(@PathVariable int id) {
        productCategoryService.deleteProductCategory(id);
    }

    @GetMapping
    public List<ProductCategoryResponse> getAllProductCategories() {
        return toResponseList(productCategoryService.getAllProductCategories());
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
