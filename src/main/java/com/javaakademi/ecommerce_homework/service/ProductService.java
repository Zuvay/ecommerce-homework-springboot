package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.Product;
import com.javaakademi.ecommerce_homework.entity.ProductCategory;
import com.javaakademi.ecommerce_homework.repository.ProductCategoryRepository;
import com.javaakademi.ecommerce_homework.repository.ProductRepository;
import com.javaakademi.ecommerce_homework.request.ProductRequest;
import com.javaakademi.ecommerce_homework.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository categoryRepository;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = toEntity(request);
        productRepository.save(product);
        return toResponse(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    private Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        ProductCategory productCategory = categoryRepository.findByName(request.getCategoryName());
        product.setCategory(productCategory);
        return product;
    }

    private ProductResponse toResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setCategory(product.getCategory().getName());
        return productResponse;
    }

}
