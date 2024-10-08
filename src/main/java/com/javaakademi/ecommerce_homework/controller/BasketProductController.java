package com.javaakademi.ecommerce_homework.controller;

import com.javaakademi.ecommerce_homework.entity.BasketProduct;
import com.javaakademi.ecommerce_homework.response.BasketProductResponse;
import com.javaakademi.ecommerce_homework.service.BasketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basketproducts")
public class BasketProductController {
    @Autowired
    private BasketProductService basketProductService;

    @PostMapping("/{productID}")
    public BasketProductResponse createBasketProduct(@PathVariable int productID){
        return basketProductService.createBasketProduct(productID);
    }
}
