package com.javaakademi.ecommerce_homework.controller;

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
    public ProductResponse addProduct(@RequestBody ProductRequest request){
        return productService.createProduct(request);
    }
    @GetMapping
    public List<ProductResponse> getAll(){
        return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
    @PutMapping("/{id}")
    public ProductResponse updateProduct(@RequestBody ProductRequest request,@PathVariable int id){
        return productService.updateProduct(request,id);
    }
}
