package com.javaakademi.ecommerce_homework.domain.product.api;

import com.javaakademi.ecommerce_homework.domain.product.impl.Product;
import com.javaakademi.ecommerce_homework.domain.product.web.ProductRequest;
import com.javaakademi.ecommerce_homework.domain.product.web.ProductResponse;

import java.util.List;

public interface ProductService {
    Product findById(int id);

    ProductDto createProduct(ProductDto dto);

    List<ProductDto> getAll();
}
