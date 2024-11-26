package com.javaakademi.ecommerce_homework.domain.product.web;

import com.javaakademi.ecommerce_homework.domain.product.api.ProductDto;
import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import com.javaakademi.ecommerce_homework.domain.product.impl.ProductServiceImpl;
import com.javaakademi.ecommerce_homework.domain.productcategory.api.ProductCategoryDto;
import com.javaakademi.ecommerce_homework.domain.productcategory.web.ProductCategoryController;
import com.javaakademi.ecommerce_homework.domain.productcategory.web.ProductCategoryRequest;
import com.javaakademi.ecommerce_homework.domain.productcategory.web.ProductCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return toResponse(productService.createProduct(toDto(productRequest)));
    }
    @GetMapping
    public List<ProductResponse> gelAllProduct(){
        return toResponseList(productService.getAll());
    }

    public static ProductResponse toResponse(ProductDto dto){
        return ProductResponse.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .categoryDto(dto.getCategoryDto())
                .build();
    }
    public static ProductDto toDto(ProductRequest request) {
        return ProductDto.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
    }

    public static List<ProductResponse> toResponseList(List<ProductDto> dtos) {
        return dtos.stream()
                .map(ProductController::toResponse)
                .collect(Collectors.toList());
    }
}
