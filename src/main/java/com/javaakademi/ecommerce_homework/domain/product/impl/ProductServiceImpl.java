package com.javaakademi.ecommerce_homework.domain.product.impl;

import com.hazelcast.core.HazelcastInstance;
import com.javaakademi.ecommerce_homework.config.HazelcastConfig;
import com.javaakademi.ecommerce_homework.domain.product.api.ProductService;
import com.javaakademi.ecommerce_homework.domain.productcategory.impl.ProductCategory;
import com.javaakademi.ecommerce_homework.domain.user.impl.UserServiceImpl;
import com.javaakademi.ecommerce_homework.exception.TrendyolException;
import com.javaakademi.ecommerce_homework.domain.product.web.ProductRequest;
import com.javaakademi.ecommerce_homework.domain.product.web.ProductResponse;
import com.javaakademi.ecommerce_homework.domain.product.api.ProductDto;
import com.javaakademi.ecommerce_homework.response.ErrorCodes;
import com.javaakademi.ecommerce_homework.domain.productcategory.impl.ProductCategoryServiceImpl;
import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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
    @Autowired
    private HazelcastConfig hazelcastConfig;

    @Override
    public Product findById(int id) {
        // Önce cache bakıyoruz
        Product cachedProduct = hazelcastConfig.get(String.valueOf(id));
        if (cachedProduct != null) {
            return cachedProduct;
        }

        // Cache de yoksa, veri tabanından getirip cachee ekliyoruz
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        hazelcastConfig.put(String.valueOf(id), product);
        return product;
    }
    @Override
    public ProductDto createProduct(ProductDto dto) {
        Product product = toEntity(dto);
        productRepository.save(product);

        //dbden sonra cache de ekliyoruz
        hazelcastConfig.put(String.valueOf(product.getId()), product);
        return toDto(product);
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
