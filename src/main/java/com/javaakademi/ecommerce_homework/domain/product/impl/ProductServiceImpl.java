package com.javaakademi.ecommerce_homework.domain.product.impl;

import com.javaakademi.ecommerce_homework.domain.product.api.ProductService;
import com.javaakademi.ecommerce_homework.domain.productcategory.impl.ProductCategory;
import com.javaakademi.ecommerce_homework.domain.user.impl.UserServiceImpl;
import com.javaakademi.ecommerce_homework.exception.TrendyolException;
import com.javaakademi.ecommerce_homework.domain.product.web.ProductRequest;
import com.javaakademi.ecommerce_homework.domain.product.web.ProductResponse;
import com.javaakademi.ecommerce_homework.domain.product.api.ProductDto;
import com.javaakademi.ecommerce_homework.response.ErrorCodes;
import com.javaakademi.ecommerce_homework.domain.productcategory.impl.ProductCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public ProductDto createProduct(ProductDto dto) {
//        Product product = toEntity(request);
//        productRepository.save(product);
//        return toResponse(product);
        return null;
    }

    public List<ProductDto> getAll() {
        return toDtoList(productRepository.findAll());
    }

    public static List<ProductDto> toDtoList(List<Product> products) {
        return products.stream()
                .map(ProductServiceImpl::toDto)
                .collect(Collectors.toList());
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .categoryId(product.getCategory().getId())
                .price(product.getPrice())
                .id(product.getId())
                .build();
    }
    public Product toEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .category(productCategoryService.findById(productDto.getId()))
                .price(productDto.getPrice())
                .build();
    }
    public List<Product> toEntityList(List<ProductDto> productDtos) {
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            products.add(toEntity(productDto));
        }
        return products;
//        return productDtos.stream()
//                .map(ProductServiceImpl::toEntity)
//                .collect(Collectors.toList());
    }


}
