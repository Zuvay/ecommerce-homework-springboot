package com.javaakademi.ecommerce_homework.controller;

import com.javaakademi.ecommerce_homework.entity.Basket;
import com.javaakademi.ecommerce_homework.request.BasketRequest;
import com.javaakademi.ecommerce_homework.request.ProductRequest;
import com.javaakademi.ecommerce_homework.response.BasketResponse;
import com.javaakademi.ecommerce_homework.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    private BasketService basketService;

    @PostMapping("/{id}")
    public BasketResponse addProductInBasket(@RequestBody BasketRequest request, @PathVariable int id){
        return basketService.addProductInBasket(request,id);
    }
    @GetMapping
    public List<BasketResponse> getAllItems(){
        return basketService.getAllProductsInBasket();
    }
}