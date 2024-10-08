package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;
import com.javaakademi.ecommerce_homework.entity.Shop;
import com.javaakademi.ecommerce_homework.repository.ProductCategoryRepository;
import com.javaakademi.ecommerce_homework.repository.ShopRepository;
import com.javaakademi.ecommerce_homework.request.ProductCategoryRequest;
import com.javaakademi.ecommerce_homework.response.ProductCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ShopRepository shopRepository;

    public ProductCategoryResponse createProductCategory(ProductCategoryRequest request,int shopID) {
        ProductCategory category = toEntity(request);
        assignCategoryToShop(category,shopID);
        productCategoryRepository.save(category);
        return toResponse(category);
    }

    private void assignCategoryToShop(ProductCategory category,int shopID) {
        Shop shop = shopRepository.findById(shopID).orElseThrow();
        category.setShop(shop);
    }

    public void deleteProductCategory(int id){
        productCategoryRepository.deleteById(id);
    }
    public List<ProductCategoryResponse> getAllProductCategories(){
        List<ProductCategory> categories = productCategoryRepository.findAll();
        List<ProductCategoryResponse> productCategoryResponses = new ArrayList<>();

        for(ProductCategory category:categories){
            productCategoryResponses.add(toResponse(category));
        }
        return productCategoryResponses;
    }
    public ProductCategoryResponse updateProductCategory(ProductCategoryRequest request, int id) {
        ProductCategory existingCategory = productCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product category not found"));

        existingCategory.setName(request.getProductCategoryName());

        productCategoryRepository.save(existingCategory);

        return toResponse(existingCategory);
    }

    public ProductCategory toEntity(ProductCategoryRequest request){
        ProductCategory category = new ProductCategory();
        category.setName(request.getProductCategoryName());
        return category;
    }

    public ProductCategoryResponse toResponse(ProductCategory category){
        ProductCategoryResponse response = new ProductCategoryResponse();
        response.setProductCategoryName(category.getName());
        response.setShopName(category.getShop().getShopName());
        return response;
    }
}
