package com.javaakademi.ecommerce_homework.controller;


import com.javaakademi.ecommerce_homework.entity.Basket;
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

    @GetMapping
    public List<BasketResponse> findAll() {
        return basketService.findAll();
    }

    @PostMapping("/{productID}/{userID}")
    public BasketResponse addBasketProductToBasket(@PathVariable int productID, @PathVariable int userID) {
        return basketService.addProductInBasket(productID,userID);
    }
}
