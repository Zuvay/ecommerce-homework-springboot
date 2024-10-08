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

    @PostMapping("/{userID}")
    public BasketResponse createBasketForUser(@PathVariable int userID) {
        return basketService.createBasketForUser(userID);
    }
    @PostMapping("/addbasketproduct/{basketProductID}/{basketID}")
    public void addBasketProduct(@PathVariable int basketProductID,@PathVariable int basketID){
         basketService.putBasketProductInBasket(basketProductID,basketID);
    }

    @GetMapping
    public List<BasketResponse> findAll() {
        return basketService.findAll();
    }

    @PutMapping("/{productID}/{basketID}")
    public void addAmountOfProductOneByOne(@PathVariable int productID, @PathVariable int basketID) {
        basketService.addAmountOfProductOneByOne(productID, basketID);
    }

}
