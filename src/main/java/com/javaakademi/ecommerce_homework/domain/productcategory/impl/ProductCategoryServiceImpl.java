package com.javaakademi.ecommerce_homework.domain.productcategory.impl;


import com.javaakademi.ecommerce_homework.domain.product.impl.ProductServiceImpl;
import com.javaakademi.ecommerce_homework.domain.productcategory.api.ProductCategoryDto;
import com.javaakademi.ecommerce_homework.domain.productcategory.api.ProductCategoryService;
import com.javaakademi.ecommerce_homework.domain.shop.impl.Shop;
import com.javaakademi.ecommerce_homework.domain.shop.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository repository;
    @Autowired
    private ShopServiceImpl shopService;
    @Autowired
    private ProductServiceImpl productService;

    public ProductCategory findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public ProductCategoryDto createProductCategory(ProductCategoryDto dto, int shopId) {
        ProductCategoryDto category = dto;
        assignCategoryToShop(toEntity(category), shopId);
        repository.save(toEntity(category));
        return category;
    }


    public void assignCategoryToShop(ProductCategory category, int shopId) {
        Shop shop = shopService.findShopById(shopId);
        category.setShop(shop);
    }

    public void deleteProductCategory(int id) {
        repository.deleteById(id);
    }

    public List<ProductCategoryDto> getAllProductCategories() {
        List<ProductCategory> categories = repository.findAll();
        List<ProductCategoryDto> productCategoryDtos = new ArrayList<>();

        for (ProductCategory category : categories) {
            productCategoryDtos.add(toDto(category));
        }
        return productCategoryDtos;
    }
    public static ProductCategoryDto toDto(ProductCategory productCategory) {
        return ProductCategoryDto.builder()
                .name(productCategory.getName())
                .shopId(productCategory.getShop().getId())
                .id(productCategory.getId())
                .products(ProductServiceImpl.toDtoList(productCategory.getProducts()))
                .build();
    }

    public static List<ProductCategoryDto> toDtoList(List<ProductCategory> productCategories) {
            return productCategories.stream()
                    .map(ProductCategoryServiceImpl::toDto)
                    .collect(Collectors.toList());

    }
    public ProductCategory toEntity(ProductCategoryDto dto){
        return ProductCategory.builder()
                .id(dto.getId())
                .name(dto.getName())
                .shop(shopService.findShopById(dto.getId()))
                .products(productService.toEntityList(dto.getProducts()))
                .build();
    }
}
