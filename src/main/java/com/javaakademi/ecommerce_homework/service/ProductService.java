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
    private ProductRepository productRepository;
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

        productRepository.save(product);
        return toResponse(product);
    }
    public List<ProductResponse> getAllProducts() {
        List<Product> products= productRepository.findAll();
        List<ProductResponse> productResponses=new ArrayList<>();
        for(Product product:products){
            productResponses.add(toResponse(product));
        }
        return productResponses;
    }
    public void deleteProduct(int id){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        product.setCategories(new ArrayList<>());
        productRepository.deleteById(id);
    }
    public ProductResponse updateProduct(ProductRequest request, int id) {
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        updateProduct.setName(request.getName());
        updateProduct.setPrice(request.getPrice());

        List<ProductCategory> updatedCategories = new ArrayList<>();
        for (String categoryName : request.getCategoryNames()) {
            ProductCategory category = categoryRepository.findByName(categoryName);
            if (category != null) {
                updatedCategories.add(category);
            }
        }

        updateProduct.setCategories(updatedCategories);

        productRepository.save(updateProduct);

        return toResponse(updateProduct);
    }

    public Product toEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setCategories(new ArrayList<>());
        product.setPrice(request.getPrice());
        return product;
    }

    public ProductResponse toResponse(Product product){
        ProductResponse response = new ProductResponse();
        response.setName(product.getName());
        response.setPrice(product.getPrice());

        List<String> productCategories = new ArrayList<>();
        for(ProductCategory category:product.getCategories()){
            productCategories.add(category.getName());
        }

        response.setCategories(productCategories);
        return response;
    }
}
