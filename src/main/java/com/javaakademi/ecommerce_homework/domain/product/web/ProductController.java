package com.javaakademi.ecommerce_homework.domain.product.web;

import com.javaakademi.ecommerce_homework.domain.product.api.ProductDto;
import com.javaakademi.ecommerce_homework.domain.product.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return toResponse(service.createProduct(toDto(productRequest)));
    }
    @GetMapping
    public List<ProductResponse> gelAllProduct(){
        return toResponseList(service.getAll());
    }

    public static ProductResponse toResponse(ProductDto dto){
        return ProductResponse.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .categoryId(dto.getCategoryId())
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
