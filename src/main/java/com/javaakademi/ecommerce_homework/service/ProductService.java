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


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductCategoryRepository categoryRepository;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = toEntity(request);

        // Kategorileri ayarlama
        List<ProductCategory> categories = new ArrayList<>();
        for (String categoryName : request.getCategoryNames()) {
            ProductCategory category = categoryRepository.findByName(categoryName);
            if (category != null) {
                categories.add(category);
            }
        }
        product.setCategories(categories);

        repository.save(product);
        return toResponse(product);
    }
    public List<ProductResponse> getAllProducts() {
        List<Product> products= repository.findAll();
        List<ProductResponse> productResponses=new ArrayList<>();
        for(Product product:products){
            productResponses.add(toResponse(product));
        }
        return productResponses;
    }

    public Product toEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setCategories(new ArrayList<>());
        product.setAmount(request.getAmount());
        product.setPrice(request.getPrice());
        return product;
    }

    public ProductResponse toResponse(Product product){
        ProductResponse response = new ProductResponse();
        response.setName(product.getName());
        response.setAmount(product.getAmount());
        response.setPrice(product.getPrice());

        List<String> productCategories = new ArrayList<>();
        for(ProductCategory category:product.getCategories()){
            productCategories.add(category.getName());
        }

        response.setCategories(productCategories);
        return response;
    }
}
