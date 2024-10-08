package com.javaakademi.ecommerce_homework.controller;

import com.javaakademi.ecommerce_homework.entity.Product;
import com.javaakademi.ecommerce_homework.request.ProductRequest;
import com.javaakademi.ecommerce_homework.response.ProductResponse;
import com.javaakademi.ecommerce_homework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }
    @GetMapping
    public List<Product> gelAllProduct(){
        return productService.getAll();
    }

}
