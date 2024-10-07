package com.javaakademi.ecommerce_homework.service;

import com.javaakademi.ecommerce_homework.entity.ProductCategory;
import com.javaakademi.ecommerce_homework.entity.Shop;
import com.javaakademi.ecommerce_homework.repository.ShopRepository;
import com.javaakademi.ecommerce_homework.request.ProductCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductCategoryService productCategoryService;


    public ProductCategory createAndAssignCategoryToShop(ProductCategoryRequest request, int shopID) {
        ProductCategory category = productCategoryService.createProductCategory(request);

        Shop shop = shopRepository.findById(shopID).orElseThrow();

        List<ProductCategory> categories = shop.getCategories();
        categories.add(category);
        shop.setCategories(categories);

        shopRepository.save(shop);

        return category;
    }
}
